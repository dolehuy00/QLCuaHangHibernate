
package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class BtnResetVegetableNHListener extends MouseAdapter {
    NhapHangVegetableGUI context;
    public BtnResetVegetableNHListener(NhapHangVegetableGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (context.ds_lbl_congcu[0].getText().equals("ADD NEW")) {
               context.setNullAllInput();
            }else if (context.ds_lbl_congcu[1].getText().equals("SAVE EDIT")) {
                context.setNullAllInput();
            }else{
                context.setNullAllInfo();
                Object category = context.getCateFilter();
                List list = context.vegetableBLL.loadVegetable(category);
                Object[][] data = context.vegetableBLL.convertListTable(list);        
                context.loadVegetable(data);
            }
        }
}
