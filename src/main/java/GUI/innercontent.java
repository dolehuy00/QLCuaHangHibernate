/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class innercontent {
    public  JPanel pnl_input,pnl_tuongtac,top_content;
    public  JPanel pnl_information,pnl_contentbottom;
    public  JPanel pnl_contentmenu_ncc;
    
    public innercontent(){
        top_content= new JPanel();
        top_content.setBounds(20, 20, 980, 260);
        top_content.setBackground(null);
        top_content.setLayout(null);
        content.pnl_content.add(top_content);

        pnl_input=new JPanel();
        pnl_input.setBackground(Color.white);
        pnl_input.setOpaque(true);
        pnl_input.setLayout(null);
        pnl_input.setBounds(0, 0, 700, 260);
        top_content.add(pnl_input);

        pnl_tuongtac=new JPanel();
        pnl_tuongtac.setBackground(Color.white);
        pnl_tuongtac.setOpaque(true);
        pnl_tuongtac.setLayout(null);
        pnl_tuongtac.setBounds(720, 0, 260, 260);
        top_content.add(pnl_tuongtac);

        pnl_contentbottom=new JPanel();
        pnl_contentbottom.setBounds(20, 300, 980, 350);
        pnl_contentbottom.setBackground(null);
        pnl_contentbottom.setLayout(null);
        content.pnl_content.add(pnl_contentbottom);

        pnl_information=new JPanel();
        pnl_information.setBounds(0, 0, 980, 350);
        pnl_information.setBackground(Color.white);
        pnl_information.setLayout(null);
        pnl_information.setOpaque(true);
        pnl_information.setLayout(new FlowLayout());
        pnl_contentbottom.add(pnl_information);

        if(menuleftBLL.flag == 1 && MenuNhapHang.menu == 1){
            new NhapHangVegetableGUI(pnl_input,  pnl_tuongtac,  top_content,  pnl_information, pnl_contentbottom);    
        }
        if(menuleftBLL.flag == 1 && MenuNhapHang.menu == 2){
            new NhapHangCategoryGUI(pnl_input,  pnl_tuongtac,  top_content,  pnl_information, pnl_contentbottom);    
        }
        if(menuleftBLL.flag == 2){
            new HoaDonGUI(pnl_input,top_content,pnl_information,pnl_contentbottom,pnl_tuongtac);    
        }
        if(menuleftBLL.flag == 3 ){
            new QLKhachHangGUI(pnl_input,  pnl_tuongtac,  top_content,  pnl_information, pnl_contentbottom);    
        } 
    }
}


