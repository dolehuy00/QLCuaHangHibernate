/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class MenuQLKhachHang extends JPopupMenu {
    private JMenuItem menuCustomers;
    private Separator separator;
    public static int menu;
    JLabel btn;

    public MenuQLKhachHang(JLabel btn) {
        this.btn = btn;
        init();
    }

    public final void init(){
        menuCustomers = new JMenuItem("Customers");
        menuCustomers.setPreferredSize(new Dimension(150, 50));
        
        separator = new Separator();
                
        
        this.setPreferredSize(new Dimension(150, 100));
        this.add(menuCustomers);
        this.add(separator);
        
        
        menuCustomers.addActionListener((e) -> {
            menu =1;
            btn.setText("Quản Lí Khách Hàng");
            content.pnl_content.removeAll();
            new innercontent();
            content.pnl_content.repaint();
            content.pnl_content.validate();
        });
        
        
    }
    
}