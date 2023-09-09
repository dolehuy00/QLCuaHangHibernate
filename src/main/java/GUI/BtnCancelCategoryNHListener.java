
package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BtnCancelCategoryNHListener extends MouseAdapter { 
    NhapHangCategoryGUI context;
    public BtnCancelCategoryNHListener(NhapHangCategoryGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (context.ds_lbl_congcu[0].getText().equals("ADD NEW")) {
            context.ds_lbl_congcu[0].setText("ADD");
            context.setNullAllInfo();
            context.ds_lbl_congcu[4].setVisible(false);
            context.ds_lbl_congcu[0].setBorder(null);
            context.ds_lbl_congcu[1].setVisible(true);
            context.ds_lbl_congcu[2].setVisible(true);
        }else if (context.ds_lbl_congcu[1].getText().equals("SAVE EDIT")) {
            context.ds_lbl_congcu[1].setText("EDIT");
            context.setNullAllInfo();
            context.ds_lbl_congcu[4].setVisible(false);
            context.ds_lbl_congcu[1].setBorder(null);
            context.ds_lbl_congcu[0].setVisible(true);
            context.ds_lbl_congcu[2].setVisible(true);
        }
    }
}
