package GUI;

import BLL.categoryBLL;
import BLL.vegetableBLL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class NhapHangVegetableGUI {
    
    JPanel pnl_input,pnl_image,top_content,pnl_contentbottom,pnl_information;
    public  JPanel pnl_congcu,pnl_search_vege,pnl_search_container;
    public  String[] title_ifm_vege={"Name","Unit","Amount","Price"};
    public  JPanel[] list_pnl_vege=new JPanel[title_ifm_vege.length];
    public  JTextField[] list_input_vege= new JTextField[title_ifm_vege.length];
    
    public  String[] btn_congcu={"ADD","EDIT","DELETE","RESET","CANCEL"};
    public  JLabel[] ds_lbl_congcu=new JLabel[btn_congcu.length];
    
    public  JLabel lbl_timkiem,lbl_id,lbl_image,lbl_btn_image,lbl_input_image;
    public  JTextField txt_timkiem;
    
    public  JComboBox cb_categoryFilter, cb_categoryInput;
            
    public  JTable table_vege;
    public  DefaultTableModel tb_vege_model;
    
    public ImageIcon image_icon;
    public Image image;
    
    categoryBLL categoryBLL = new categoryBLL();
    vegetableBLL vegetableBLL = new vegetableBLL();
    
    List listCategory = categoryBLL.loadCategory();
    
    public NhapHangVegetableGUI(JPanel pnl_input, JPanel pnl_tuongtac, JPanel top_content,
            JPanel pnl_information,JPanel pnl_contentbottom) {
        this.pnl_input = pnl_input;//
        this.pnl_image = pnl_tuongtac;//
        this.top_content = top_content;
        this.pnl_congcu = pnl_congcu;//
        this.pnl_information = pnl_information;//
        this.pnl_contentbottom = pnl_contentbottom;
        init();
    }
    public void init(){
        congcu();
        VegetableTable();
    }
  
    public void congcu(){
        for(int i=0; i<title_ifm_vege.length;i++){
            list_pnl_vege[i]=new JPanel();
            list_pnl_vege[i].setBorder(BorderFactory.createTitledBorder(title_ifm_vege[i]));
            list_pnl_vege[i].setBackground(null);
            list_pnl_vege[i].setLayout(new FlowLayout());
            pnl_input.add(list_pnl_vege[i]);

            list_input_vege[i]=new JTextField();
            list_input_vege[i].setBackground(null);
            list_input_vege[i].setBorder(new MatteBorder(0, 0, 3, 0, new Color(0, 0, 60)));
            list_input_vege[i].setPreferredSize(new Dimension(150, 20));
            list_pnl_vege[i].add(list_input_vege[i]);
        }
        list_pnl_vege[0].setBounds(205, 0, 180, 60);//name
        list_pnl_vege[1].setBounds(20, 60, 180, 60);//unit
        list_pnl_vege[2].setBounds(205, 60, 180, 60);//amout
        list_pnl_vege[3].setBounds(390, 60, 180, 60);//price
        
        //id
        lbl_id=new JLabel();
        lbl_id.setText(null);
        lbl_id.setBounds(20, 0, 180, 60);
        lbl_id.setBackground(null);
        lbl_id.setBorder(BorderFactory.createTitledBorder("ID"));
        pnl_input.add(lbl_id);
        
        // image
        lbl_input_image=new JLabel("",JLabel.CENTER);
        lbl_input_image.setBounds(20, 120, 180, 60);
        lbl_input_image.setBackground(null);
        lbl_input_image.setBorder(BorderFactory.createTitledBorder("Image"));
        pnl_input.add(lbl_input_image);

        lbl_btn_image = new JLabel("",JLabel.CENTER);
        lbl_btn_image.setBackground(new Color(0, 0, 60));
        lbl_btn_image.setOpaque(true);
        lbl_btn_image.setText("Chọn Ảnh");
        lbl_btn_image.setForeground(Color.white);
        lbl_btn_image.setBounds(202, 148, 70, 30);
        pnl_input.add(lbl_btn_image);
        lbl_btn_image.addMouseListener(new BtnChooseImageVegetableNHListener(this));
        
        //combobox input
        CategoryModel categoryInputCBModel = new CategoryModel(
                categoryBLL.convertListComboBox(listCategory));
        cb_categoryInput=new JComboBox(categoryInputCBModel);
        cb_categoryInput.setBounds(390, 0, 180, 60);
        cb_categoryInput.setBackground(null);
        cb_categoryInput.setBorder(BorderFactory.createTitledBorder("Category"));
        cb_categoryInput.setLightWeightPopupEnabled(true);
        pnl_input.add(cb_categoryInput);
        
        //cong cu
        pnl_congcu=new JPanel();
        pnl_congcu.setBounds(560, 5, 140, 180);
        pnl_congcu.setBackground(null);
        pnl_input.add(pnl_congcu);

        for(int i=0;i<btn_congcu.length;i++){           
            ds_lbl_congcu[i]=new JLabel(btn_congcu[i],JLabel.CENTER);
            ds_lbl_congcu[i].setBackground(new Color(0, 0, 60));
            ds_lbl_congcu[i].setOpaque(true);
            ds_lbl_congcu[i].setForeground(Color.white);
            ds_lbl_congcu[i].setPreferredSize(new Dimension(100, 40));
            pnl_congcu.add(ds_lbl_congcu[i]);
        }
        
        // xu ly su kien them
        ds_lbl_congcu[0].addMouseListener(new BtnAddVegetableNHListener(this));
        // xu ly su kien sua
        ds_lbl_congcu[1].addMouseListener(new BtnEditVegetableNHListener(this));
        // xu ly su kien xoa
        ds_lbl_congcu[2].addMouseListener(new BtnDeleteVegetableNHListener(this));
        // xu ly su kien lam moi
        ds_lbl_congcu[3].addMouseListener(new BtnResetVegetableNHListener(this));
        // xu ly su kien huy bo
        ds_lbl_congcu[4].addMouseListener(new BtnCancelVegetableNHListener(this));
        
        //tim kiem
        pnl_search_container=new JPanel();
        pnl_search_container.setBackground(null);
        pnl_search_container.setBorder(new MatteBorder(2, 0, 0, 0, new Color(0, 0, 60)));
        pnl_search_container.setBounds(0, 190, 700, 70);
        pnl_input.add(pnl_search_container);

        pnl_search_vege=new JPanel();
        pnl_search_vege.setPreferredSize(new Dimension(280,60));
        pnl_search_vege.setBackground(null);
        pnl_search_vege.setBorder(BorderFactory.createTitledBorder("Search by name"));
        pnl_search_container.add(pnl_search_vege);

        txt_timkiem=new JTextField();
        txt_timkiem.setPreferredSize(new Dimension(260, 30));
        txt_timkiem.setBackground(null);
        txt_timkiem.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 0, 60)));
        pnl_search_vege.add(txt_timkiem);

        lbl_timkiem=new JLabel("SEARCH",JLabel.CENTER);
        lbl_timkiem.setBackground(new Color(0, 0, 60));
        lbl_timkiem.setOpaque(true);
        lbl_timkiem.setForeground(Color.white);
        lbl_timkiem.setPreferredSize(new Dimension(100, 40));
        pnl_search_container.add(lbl_timkiem);
        
        // xu ly su kien tim kiem
        lbl_timkiem.addMouseListener(new BtnSearchVegetableNHListener(this));
    }

    public void inner_img(ImageIcon icon){
        pnl_image.removeAll();
        lbl_image=new JLabel(icon,JLabel.CENTER);
        lbl_image.setBounds(0, 0, 260, 260);
        pnl_image.add(lbl_image);
        pnl_image.repaint();
        pnl_image.validate();
    }

    public void VegetableTable(){
        String[] colum={"ID","Name","Category","Unit","Amount","Price"};
        tb_vege_model=new DefaultTableModel(null, colum);
        table_vege=new JTable();
        table_vege.setModel(tb_vege_model);
        table_vege.setRowHeight(30);
        table_vege.setGridColor(new Color(0, 0, 60));
        table_vege.setAutoCreateRowSorter(true);
        table_vege.getTableHeader().setBackground(new Color(0, 0, 60));
        table_vege.getTableHeader().setForeground(Color.white);
        table_vege.setPreferredScrollableViewportSize(new Dimension(970, 320));
        pnl_information.add(new JScrollPane(table_vege));   
        table_vege.addMouseListener(new TableVegetableNHListener(this));
        inner_combobox_vegeTypeFilter();
        //load vegetable 
        List list = vegetableBLL.loadVegetable(getCateFilter());
        Object[][] data = vegetableBLL.convertListTable(list);
        loadVegetable(data);
    }
        
    public void loadVegetable(Object[][] data){
        tb_vege_model.setRowCount(0);
        for (Object[] row : data) {
            tb_vege_model.addRow(row);
        }
    }
    public void inner_combobox_vegeTypeFilter(){
        CategoryModel categoryFilterCBModel = new CategoryModel(
                categoryBLL.convertListComboBox(listCategory));
        cb_categoryFilter=new JComboBox(categoryFilterCBModel);
        cb_categoryFilter.insertItemAt("All Category", 0);
        cb_categoryFilter.setSelectedItem("All Category");
        cb_categoryFilter.setBounds(0, 0, 150, 60);
        cb_categoryFilter.setBackground(null);
        cb_categoryFilter.setBorder(BorderFactory.createTitledBorder("Category"));
        cb_categoryFilter.setLightWeightPopupEnabled(true);
        pnl_search_container.add(cb_categoryFilter);
        cb_categoryFilter.addActionListener((ActionEvent e) -> {
            String name = txt_timkiem.getText();
            List list = vegetableBLL.searchVegetable(name, getCateFilter());
            Object[][] data = vegetableBLL.convertListTable(list);
            loadVegetable(data);
        });   
    }
    
    public void setNullAllInput(){
        for(int i=0; i<title_ifm_vege.length;i++){
            list_input_vege[i].setText(null);
        }
    }
    
    public void setNullAllInfo(){
        for(int i=0; i<title_ifm_vege.length;i++){
            list_input_vege[i].setText(null);
        }
        lbl_id.setText(null);
        lbl_input_image.setText(null);
        txt_timkiem.setText(null);
    }
    
    public Object getCateFilter(){
        return cb_categoryFilter.getModel().getSelectedItem();
    }

    public boolean checkDataInput(){
        if ("".equals(list_input_vege[0].getText())) {
            JOptionPane.showMessageDialog(null, "Please enter 'Name'!");
            return false;
        }
        if ("".equals(list_input_vege[1].getText())) {
            JOptionPane.showMessageDialog(null, "Please enter 'Unit'!");
            return false;
        }
        if ("".equals(list_input_vege[2].getText())) {
            JOptionPane.showMessageDialog(null, "Please enter 'Amount'!");
            return false;
        }
        if(!(vegetableBLL.isInteger((String)list_input_vege[2].getText()))){
            JOptionPane.showMessageDialog(null, "'Amount' must be number!");
            return false;
        }
        if ("".equals(list_input_vege[3].getText())) {
            JOptionPane.showMessageDialog(null, "Please enter 'Price'!");
            return false;
        }
        if(!(vegetableBLL.isFloat((String)list_input_vege[3].getText()))){
            JOptionPane.showMessageDialog(null, "'Price' must be number!");
            return false;
        }
        if ("".equals(lbl_input_image.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter 'Image'!");
            return false;
        }
        return true;
    }
}
