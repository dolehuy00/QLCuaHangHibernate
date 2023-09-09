package GUI;

import BLL.orderBLL;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class HoaDonGUI {
    
    JPanel  pnl_input, pnl_tuongtac, top_content,pnl_contentbottom,pnl_information;
    public  JPanel pnl_congcu,pnl_search,pnl_search_border;
    
    public  String[] btn_congcu={"ADD","RELOAD"};
    public  JLabel[] ds_lbl_congcu=new JLabel[btn_congcu.length];
    
    public  JLabel lbl_search;
    public  JTextField input_search;
    
    
    public  JTable table;
    public  DefaultTableModel table_model;
    
    orderBLL orderBLL = new orderBLL();

    public HoaDonGUI() {
    }
    
    public HoaDonGUI(JPanel pnl_input, JPanel top_content,
            JPanel pnl_information,JPanel pnl_contentbottom, JPanel pnl_tuongtac) {
        this.pnl_input = pnl_input;
        this.top_content = top_content;
        this.pnl_tuongtac = pnl_tuongtac;
        this.pnl_congcu = pnl_congcu;
        this.pnl_information = pnl_information;
        this.pnl_contentbottom = pnl_contentbottom;
        init();
    }
    private void init(){
        CongCu();
        CategoryTable();
    }
  
    private void CongCu(){
        pnl_tuongtac.setVisible(false);
        pnl_input.setSize(980, 100);
        top_content.setSize(980, 100);
        pnl_contentbottom.setBounds(20, 140, 980, 500);
        pnl_information.setSize(980, 500);
        //cong cu
        pnl_congcu=new JPanel();
        pnl_congcu.setBackground(null);
        pnl_congcu.setBounds(560, 20, 340, 50);
        pnl_input.add(pnl_congcu);
        
        for(int i=0;i<btn_congcu.length;i++){           
            ds_lbl_congcu[i]=new JLabel(btn_congcu[i],JLabel.CENTER);
            ds_lbl_congcu[i].setBackground(new Color(0, 0, 60));
            ds_lbl_congcu[i].setOpaque(true);
            ds_lbl_congcu[i].setForeground(Color.white);
            ds_lbl_congcu[i].setPreferredSize(new Dimension(100, 40));
            pnl_congcu.add(ds_lbl_congcu[i]);
        }
        
        //tim kiem
        pnl_search_border=new JPanel();
        pnl_search_border.setBackground(null);
        pnl_search_border.setBounds(0, 10, 500, 70);
        pnl_input.add(pnl_search_border);
        
        pnl_search=new JPanel();
        pnl_search.setPreferredSize(new Dimension(280,60));
        pnl_search.setBackground(null);
        pnl_search.setBorder(BorderFactory.createTitledBorder("Search by name customer"));
        pnl_search_border.add(pnl_search);

        input_search=new JTextField();
        input_search.setPreferredSize(new Dimension(260, 30));
        input_search.setBackground(null);
        input_search.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 0, 60)));
        pnl_search.add(input_search);

        lbl_search=new JLabel("SEARCH",JLabel.CENTER);
        lbl_search.setBackground(new Color(0, 0, 60));
        lbl_search.setOpaque(true);
        lbl_search.setForeground(Color.white);
        lbl_search.setPreferredSize(new Dimension(100, 40));
        pnl_search_border.add(lbl_search);
        // xu ly su kien tim kiem
        lbl_search.addMouseListener(new BtnSearchHoaDonListener(this));
        
        // xu ly su kien them
        ds_lbl_congcu[0].addMouseListener(new BtnAddHoaDonListener(this));
        // xu ly su kien lam moi
        ds_lbl_congcu[1].addMouseListener(new BtnResetHoaDonListener(this));
        
    }

    private void CategoryTable(){
        String[] column={"ID","Customer","Date","Total","Note"};
        table=new JTable();
        table.setModel(new DefaultTableModel(null,column){
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_model = (DefaultTableModel) table.getModel();
        table.setRowHeight(30);
        table.setGridColor(new Color(0, 0, 60));
        table.setAutoCreateRowSorter(true);
        table.getTableHeader().setBackground(new Color(0, 0, 60));
        table.getTableHeader().setForeground(Color.white);
        table.setPreferredScrollableViewportSize(new Dimension(970, 470));
        pnl_information.add(new JScrollPane(table));   
        table.addMouseListener(new TableHoaDonListener(this));
        List list = orderBLL.loadOrder();
        Object[][] data = orderBLL.convertListTableOrder(list);
        loadOrders(data);
    }

    public void loadOrders(Object[][] data){
        
        table_model.setRowCount(0);
        for (Object[] row : data) {
            table_model.addRow(row);
        }
    }
    
//    public void setNullAllInput(){
//        for(int i=0; i<title_info_category.length;i++){
//            list_input_category[i].setText(null);   
//        }
//        txt_description.setText(null);
//    }
    
//    public void setNullAllInfo(){
//        for(int i=0; i<title_info_category.length;i++){
//            list_input_category[i].setText(null);   
//        }
//        lbl_id_category.setText(null);
//        txt_description.setText(null);
//    }
//    
//    public boolean checkDataInput(){
//        if ("".equals(list_input_category[0].getText())) {
//            JOptionPane.showMessageDialog(null, "Please enter 'Name'");
//            return false;
//        }
//        return true;
//    }

}
