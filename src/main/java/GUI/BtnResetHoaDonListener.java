
package GUI;

import DAL.category;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class BtnResetHoaDonListener extends MouseAdapter {  
    
    HoaDonGUI context;
    public BtnResetHoaDonListener(HoaDonGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e){
        List list = context.orderBLL.loadOrder();
        Object[][] data = context.orderBLL.convertListTableOrder(list);
        context.loadOrders(data);  
    }
}
