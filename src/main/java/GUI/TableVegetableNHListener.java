
package GUI;

import DAL.vegetable;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class TableVegetableNHListener extends MouseAdapter {
    NhapHangVegetableGUI context;
    public TableVegetableNHListener(NhapHangVegetableGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e){
        int id=(int) context.table_vege.getValueAt(context.table_vege.getSelectedRow(),0);
        vegetable ve = context.vegetableBLL.getVegetable(id);
        context.lbl_id.setText(String.valueOf(id));
        context.list_input_vege[0].setText(ve.getVegetable_Name());
        context.list_input_vege[1].setText(ve.getUnit());
        context.list_input_vege[2].setText(ve.getAmount());
        context.list_input_vege[3].setText(ve.getPrice());
        context.cb_categoryInput.getModel().setSelectedItem(ve.getCatagory());
        context.lbl_input_image.setText(ve.getImage()); 
        String imageName = ve.getImage().replace("images/", "");
        imgs img=new imgs();
        ImageIcon icon=new ImageIcon(img.imgs(imageName));
        Image ic=icon.getImage().getScaledInstance(260, 260, Image.SCALE_SMOOTH);
        icon=new ImageIcon(ic);
        context.inner_img(icon);  
    }
}
