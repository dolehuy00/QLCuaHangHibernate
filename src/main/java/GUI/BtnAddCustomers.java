
package GUI;

import DAL.customers;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class BtnAddCustomers extends MouseAdapter {
    QLKhachHangGUI context;
    public BtnAddCustomers(QLKhachHangGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(context.ds_lbl_congcu[0].getText().equals("ADD")){
                context.setNullAllInfo();
                context.lbl_id.setText("Auto Increment");
                context.ds_lbl_congcu[0].setText("ADD NEW");
                context.ds_lbl_congcu[0].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                context.ds_lbl_congcu[1].setVisible(false);
                context.ds_lbl_congcu[2].setVisible(false);
                context.ds_lbl_congcu[4].setVisible(true);
            }else if (context.checkDataInput()){
                customers c = new customers();
                c.setPassword(context.list_input_customers[0].getText());           
                c.setFullname(context.list_input_customers[1].getText());
                c.setAddress(context.list_input_customers[2].getText());
                c.setCity(context.list_input_customers[3].getText());
                boolean status = context.customersBLL.AddCustomers(c);
                if(status){
                    JOptionPane.showMessageDialog(null,"Add successfully","Insert",
                            JOptionPane.INFORMATION_MESSAGE);
               
                   
                    context.setNullAllInfo();
                    List list = context.customersBLL.loadCustomers();
                    context.loadCustomers(list);
                    context.ds_lbl_congcu[0].setText("ADD");
                    context.ds_lbl_congcu[0].setBorder(null);
                    context.ds_lbl_congcu[1].setVisible(true);
                    context.ds_lbl_congcu[2].setVisible(true);
                    context.ds_lbl_congcu[4].setVisible(false);                    
                }   else{ 
                    JOptionPane.showMessageDialog(null,"Add failure","Insert",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
    }
}
