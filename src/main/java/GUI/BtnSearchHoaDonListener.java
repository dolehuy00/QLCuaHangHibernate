/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 *
 * @author PC
 */
public class BtnSearchHoaDonListener extends MouseAdapter {  
    
    HoaDonGUI context;
    public BtnSearchHoaDonListener(HoaDonGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e){
        List list = context.orderBLL.searchOrder(context.input_search.getText());
        Object[][] data = context.orderBLL.convertListTableOrder(list);
        context.loadOrders(data);
    }
}
