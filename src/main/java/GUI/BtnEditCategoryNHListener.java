
package GUI;

import DAL.category;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class BtnEditCategoryNHListener extends MouseAdapter { 
    NhapHangCategoryGUI context;
    public BtnEditCategoryNHListener(NhapHangCategoryGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(context.ds_lbl_congcu[1].getText().equals("EDIT")){
            context.ds_lbl_congcu[1].setText("SAVE EDIT");
            context.ds_lbl_congcu[1].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            context.ds_lbl_congcu[0].setVisible(false);
            context.ds_lbl_congcu[2].setVisible(false);
            context.ds_lbl_congcu[4].setVisible(true);
        }else if(context.checkDataInput()){
                String id = context.lbl_id_category.getText();
                category c = context.categoryBLL.getCategory(Integer.parseInt(id));
                c.setName(context.list_input_category[0].getText());
                c.setDescription(context.txt_description.getText());
                boolean status = context.categoryBLL.updateCategory(c); 
                if(status){
                JOptionPane.showMessageDialog(null,"Save successfully","Save",
                        JOptionPane.INFORMATION_MESSAGE);
                context.setNullAllInfo();
                context.ds_lbl_congcu[1].setText("EDIT");
                context.ds_lbl_congcu[1].setBorder(null);
                context.ds_lbl_congcu[0].setVisible(true);
                context.ds_lbl_congcu[2].setVisible(true);
                context.ds_lbl_congcu[4].setVisible(false);
                List list = context.categoryBLL.loadCategory();
                Object[][] data = context.categoryBLL.convertListTable(list); 
                context.loadCategory(data);
            }else{
                JOptionPane.showMessageDialog(null,"Save failure","Save",
                        JOptionPane.ERROR_MESSAGE);
            }    
  
        }  
    }
}
