
package GUI;

import DAL.customers;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableCustomers extends MouseAdapter {
    QLKhachHangGUI context;
    public TableCustomers(QLKhachHangGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e){
        int id=(int) context.table_customers.getValueAt(context.table_customers.getSelectedRow(),0);
        customers cu = context.customersBLL.getCustomers(id);
        context.lbl_id.setText(String.valueOf(id));
        context.list_input_customers[0].setText(cu.getPassword());
        context.list_input_customers[1].setText(cu.getFullname());
        context.list_input_customers[2].setText(cu.getAddress());
        context.list_input_customers[3].setText(cu.getCity());                   
    }
}
