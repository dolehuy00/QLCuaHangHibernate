
package GUI;

import DAL.category;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BtnAddHoaDonListener extends MouseAdapter {  
    
    HoaDonGUI context;
    public BtnAddHoaDonListener(HoaDonGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e){
        new ChiTietHoaDonGUI(context.orderBLL);
    }
}
