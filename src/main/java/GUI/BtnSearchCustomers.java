
package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class BtnSearchCustomers extends MouseAdapter {
    QLKhachHangGUI context;
    public BtnSearchCustomers(QLKhachHangGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        String Fullname = context.txt_timkiem.getText();
        List list = context.customersBLL.searchCustomers(Fullname);
        context.loadCustomers(list);
    }
}
