
package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class BtnResetCustomers extends MouseAdapter {
    QLKhachHangGUI context;
    public BtnResetCustomers(QLKhachHangGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (context.ds_lbl_congcu[0].getText().equals("ADD NEW")) {
               context.setNullAllInput();
            }else if (context.ds_lbl_congcu[1].getText().equals("SAVE EDIT")) {
                context.setNullAllInput();
               
            }else{
                context.setNullAllInfo();
                List list = context.customersBLL.loadCustomers();
                context.loadCustomers(list);
            }
        }
}
