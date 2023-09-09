package GUI;

import BLL.customerBLL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class QLKhachHangGUI {
    
    JPanel  pnl_input,  pnl_tuongtac,  top_content,  pnl_information, pnl_contentbottom;
    public  JPanel pnl_congcu,pnl_search_customers,pnl_search_container;
    public  String[] title_ifm_customers={"Password","Fullname","Address","City"};
    public  JPanel[] list_pnl_customers=new JPanel[title_ifm_customers.length];
    public  JTextField[] list_input_customers= new JTextField[title_ifm_customers.length];
    
    public  String[] btn_congcu={"ADD","EDIT","DELETE","RESET","CANCEL"};
    public  JLabel[] ds_lbl_congcu=new JLabel[btn_congcu.length];
    
    public  JLabel lbl_timkiem,lbl_id;
    public  JTextField txt_timkiem;
                
    public  JTable table_customers;
    public  DefaultTableModel tb_customers_model;
    
    customerBLL customersBLL = new customerBLL();
    
    public QLKhachHangGUI(JPanel pnl_input, JPanel pnl_tuongtac, JPanel top_content,
            JPanel pnl_information,JPanel pnl_contentbottom) {
        this.pnl_input = pnl_input;//        
        this.top_content = top_content;
        this.pnl_congcu = pnl_congcu;//
        this.pnl_information = pnl_information;//
        this.pnl_contentbottom = pnl_contentbottom;
        init();
    }
    public void init(){
        congcu();
        CustomersTable();
    }
  
    public void congcu(){
        for(int i=0; i<title_ifm_customers.length;i++){
            list_pnl_customers[i]=new JPanel();
            list_pnl_customers[i].setBorder(BorderFactory.createTitledBorder(title_ifm_customers[i]));
            list_pnl_customers[i].setBackground(null);
            list_pnl_customers[i].setLayout(new FlowLayout());
            pnl_input.add(list_pnl_customers[i]);

            list_input_customers[i]=new JTextField();
            list_input_customers[i].setBackground(null);
            list_input_customers[i].setBorder(new MatteBorder(0, 0, 3, 0, new Color(0, 0, 60)));
            list_input_customers[i].setPreferredSize(new Dimension(150, 20));
            list_pnl_customers[i].add(list_input_customers[i]);
        }
        list_pnl_customers[0].setBounds(205, 0, 180, 60);//Password
        list_pnl_customers[1].setBounds(20, 60, 180, 60);//Fullname
        list_pnl_customers[2].setBounds(205, 60, 180, 60);//Address
        list_pnl_customers[3].setBounds(390, 60, 180, 60);//City
        //id
        lbl_id=new JLabel();
        lbl_id.setText(null);
        lbl_id.setBounds(20, 0, 180, 60);
        lbl_id.setBackground(null);
        lbl_id.setBorder(BorderFactory.createTitledBorder("ID"));
        pnl_input.add(lbl_id);
              
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
        ds_lbl_congcu[0].addMouseListener(new BtnAddCustomers(this));
        // xu ly su kien sua
        ds_lbl_congcu[1].addMouseListener(new BtnUpdateCustomers(this));
        // xu ly su kien xoa
        ds_lbl_congcu[2].addMouseListener(new BtnDeleteCustomers(this));
        // xu ly su kien lam moi
        ds_lbl_congcu[3].addMouseListener(new BtnResetCustomers(this));
        // xu ly su kien huy bo
        ds_lbl_congcu[4].addMouseListener(new BtnCancelCustomers(this));
        
        //tim kiem
        pnl_search_container=new JPanel();
        pnl_search_container.setBackground(null);
        pnl_search_container.setBorder(new MatteBorder(2, 0, 0, 0, new Color(0, 0, 60)));
        pnl_search_container.setBounds(0, 190, 700, 70);
        pnl_input.add(pnl_search_container);

        pnl_search_customers=new JPanel();
        pnl_search_customers.setPreferredSize(new Dimension(280,60));
        pnl_search_customers.setBackground(null);
        pnl_search_customers.setBorder(BorderFactory.createTitledBorder("Search by Fullname"));
        pnl_search_container.add(pnl_search_customers);

        txt_timkiem=new JTextField();
        txt_timkiem.setPreferredSize(new Dimension(260, 30));
        txt_timkiem.setBackground(null);
        txt_timkiem.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 0, 60)));
        pnl_search_customers.add(txt_timkiem);

        lbl_timkiem=new JLabel("SEARCH",JLabel.CENTER);
        lbl_timkiem.setBackground(new Color(0, 0, 60));
        lbl_timkiem.setOpaque(true);
        lbl_timkiem.setForeground(Color.white);
        lbl_timkiem.setPreferredSize(new Dimension(100, 40));
        pnl_search_container.add(lbl_timkiem);
        
        // xu ly su kien tim kiem
        lbl_timkiem.addMouseListener(new BtnSearchCustomers(this));
    }


    public void CustomersTable(){
        String[] colum={"CustomerID","Password","Fullname","Address","City"};
        tb_customers_model=new DefaultTableModel(null, colum);
        table_customers=new JTable();
        table_customers.setModel(tb_customers_model);
        table_customers.setRowHeight(30);
        table_customers.setGridColor(new Color(0, 0, 60));
        table_customers.setAutoCreateRowSorter(true);
        table_customers.getTableHeader().setBackground(new Color(0, 0, 60));
        table_customers.getTableHeader().setForeground(Color.white);
        table_customers.setPreferredScrollableViewportSize(new Dimension(970, 320));
        pnl_information.add(new JScrollPane(table_customers));   
        table_customers.addMouseListener(new TableCustomers(this));      
        //load customers
        List list = customersBLL.loadCustomers();
        loadCustomers(list);
    }
        
    public void loadCustomers(List list){
        Object[][] data = customersBLL.converCustomers(list);
        tb_customers_model.setRowCount(0);
        for (Object[] row : data) {
            tb_customers_model.addRow(row);
        }
    }
    
    public void setNullAllInput(){
        for(int i=0; i<title_ifm_customers.length;i++){
            list_input_customers[i].setText(null);
        }
    }
    
    public void setNullAllInfo(){
        for(int i=0; i<title_ifm_customers.length;i++){
            list_input_customers[i].setText(null);
        }
        lbl_id.setText(null);       
        txt_timkiem.setText(null);
    }
    
   
    public boolean checkDataInput(){
        if ("".equals(list_input_customers[0].getText())) {
            JOptionPane.showMessageDialog(null, "Please enter 'Password'!");
            return false;
        }
        if ("".equals(list_input_customers[1].getText())) {
            JOptionPane.showMessageDialog(null, "Please enter 'Fullname'!");
            return false;
        }
        if ("".equals(list_input_customers[2].getText())) {
            JOptionPane.showMessageDialog(null, "Please enter 'Address'!");
            return false;
        }
        
        if ("".equals(list_input_customers[3].getText())) {
            JOptionPane.showMessageDialog(null, "Please enter 'City'!");
            return false;
        }
         return true;
    }   
    
}