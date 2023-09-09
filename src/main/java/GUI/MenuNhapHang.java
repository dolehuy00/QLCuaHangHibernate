/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class MenuNhapHang extends JPopupMenu {
    private JMenuItem menuVegetable;
    private JMenuItem menuCategory;
    private Separator separator;
    public static int menu;
    JLabel btn;

    public MenuNhapHang(JLabel btn) {
        this.btn = btn;
        init();
    }

    public final void init(){
        menuVegetable = new JMenuItem("Vegetable");
        menuVegetable.setPreferredSize(new Dimension(150, 50));
        
        separator = new Separator();
        
        menuCategory = new JMenuItem("Category");
        menuCategory.setPreferredSize(new Dimension(150, 50));
        
        this.setPreferredSize(new Dimension(150, 100));
        this.add(menuVegetable);
        this.add(separator);
        this.add(menuCategory);
        
        menuVegetable.addActionListener((e) -> {
            menu =1;
            btn.setText("Nhập hàng (Vegetable)");
            content.pnl_content.removeAll();
            new innercontent();
            content.pnl_content.repaint();
            content.pnl_content.validate();
        });
        
        menuCategory.addActionListener((e) -> {
            menu=2;
            btn.setText("Nhập hàng (Category)");
            content.pnl_content.removeAll();
            new innercontent();
            content.pnl_content.repaint();
            content.pnl_content.validate();;
        });
    }
    
}
