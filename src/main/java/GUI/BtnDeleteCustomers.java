
package GUI;

import DAL.customers;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;

public class BtnDeleteCustomers extends MouseAdapter {
    QLKhachHangGUI context;
    public BtnDeleteCustomers(QLKhachHangGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int i=context.table_customers.getSelectedRow();
        if(i<0){
            JOptionPane.showMessageDialog(null, "Please choose customers from the table!");
        }else{
            int dialog_del = JOptionPane.showConfirmDialog(null,
                "Do you want to delete vegetable?\n"+"ID: "+
                context.table_customers.getValueAt(i,0)
                +"\n"+"Name: "+ context.table_customers.getValueAt(i,1),"Delete",
                JOptionPane.YES_NO_OPTION);
            if(dialog_del == JOptionPane.YES_OPTION){
                int id = (int) context.table_customers.getValueAt(i, 0);
                customers v = context.customersBLL.getCustomers(id);
                boolean status = context.customersBLL.deleteCustomers(v);
                if(status){
                    JOptionPane.showMessageDialog(null,"Delete successfully","Delete",
                            JOptionPane.INFORMATION_MESSAGE);
                    context.setNullAllInfo(); 
                    List list = context.customersBLL.loadCustomers();
                    context.loadCustomers(list);
                }else{
                    JOptionPane.showMessageDialog(null,"Delete failure","Delete",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
