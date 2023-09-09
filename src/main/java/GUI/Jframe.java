/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author DELL
 */
public class Jframe {
     JFrame f;
    public Jframe(){
        init();
    }
    public void init()
    {
        f=new JFrame();
        f.setSize(1240,720);
        f.setLayout(new BorderLayout(0, 0));
        new header(f);
        new menuLeft(f);
        new content(f);
        f.setUndecorated(true);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void goi(){
        
    }
    public static void main(String[] args) {
        new Jframe();
    }
}
