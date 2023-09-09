
package GUI;

import DAL.category;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class BtnAddCategoryNHListener extends MouseAdapter {
    NhapHangCategoryGUI context;
    public BtnAddCategoryNHListener(NhapHangCategoryGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(context.ds_lbl_congcu[0].getText().equals("ADD")){
                context.setNullAllInfo();
                context.lbl_id_category.setText("Auto Increment");
                context.ds_lbl_congcu[0].setText("ADD NEW");
                context.ds_lbl_congcu[0].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                context.ds_lbl_congcu[1].setVisible(false);
                context.ds_lbl_congcu[2].setVisible(false);
                context.ds_lbl_congcu[4].setVisible(true);
            }else if (context.checkDataInput()){
                category c = new category();
                c.setName(context.list_input_category[0].getText());
                c.setDescription(context.txt_description.getText());
                boolean status = context.categoryBLL.insertCategory(c);
                if(status){
                    JOptionPane.showMessageDialog(null,"Add successfully","Insert",
                            JOptionPane.INFORMATION_MESSAGE);
                    List list = context.categoryBLL.loadCategory();
                    Object[][] data = context.categoryBLL.convertListTable(list); 
                    context.loadCategory(data);
                    context.setNullAllInfo();
                    context.ds_lbl_congcu[0].setText("ADD");
                    context.ds_lbl_congcu[0].setBorder(null);
                    context.ds_lbl_congcu[1].setVisible(true);
                    context.ds_lbl_congcu[2].setVisible(true);
                    context.ds_lbl_congcu[4].setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Add failure","Insert",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
    }
}
