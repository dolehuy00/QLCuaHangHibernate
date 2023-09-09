
package GUI;

import DAL.customers;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class BtnUpdateCustomers extends MouseAdapter { 
    QLKhachHangGUI context;
    public BtnUpdateCustomers(QLKhachHangGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(context.lbl_id.getText() == null){
            JOptionPane.showMessageDialog(null, "Please choose vegetable from the table!");
        }else if(context.ds_lbl_congcu[1].getText().equals("EDIT")){
            context.ds_lbl_congcu[1].setText("SAVE EDIT");
            context.ds_lbl_congcu[1].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            context.ds_lbl_congcu[0].setVisible(false);
            context.ds_lbl_congcu[2].setVisible(false);
            context.ds_lbl_congcu[4].setVisible(true);
        }else if(context.checkDataInput()){
            customers c = context.customersBLL.getCustomers(Integer.valueOf(context.lbl_id.getText()));
            c.setPassword(context.list_input_customers[0].getText());           
                c.setFullname(context.list_input_customers[1].getText());
                c.setAddress(context.list_input_customers[2].getText());
                c.setCity(context.list_input_customers[3].getText());
                boolean status = context.customersBLL.updateCustomers(c);
            if(status){
                JOptionPane.showMessageDialog(null,"Save successfully","Save",
                        JOptionPane.INFORMATION_MESSAGE);
                context.setNullAllInfo();
                context.ds_lbl_congcu[1].setText("EDIT");
                context.ds_lbl_congcu[1].setBorder(null);
                context.ds_lbl_congcu[0].setVisible(true);
                context.ds_lbl_congcu[2].setVisible(true);
                context.ds_lbl_congcu[4].setVisible(false);
                context.loadCustomers(context.customersBLL.loadCustomers());
            }else{
                JOptionPane.showMessageDialog(null,"Save failure","Save",
                        JOptionPane.ERROR_MESSAGE);
            }    
        } 
    }
}
