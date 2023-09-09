
package GUI;

import DAL.order;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableHoaDonListener extends MouseAdapter {  
    
    HoaDonGUI context;
    public TableHoaDonListener(HoaDonGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e){
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();
            int id = (int) context.table.getValueAt(context.table.getSelectedRow(), 0);
            order order = context.orderBLL.getOrder(id);
            new ChiTietHoaDonGUI(order, context.orderBLL);
        } 
    }
}
