
package GUI;

import DAL.category;
import DAL.vegetable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class BtnAddVegetableNHListener extends MouseAdapter {
    NhapHangVegetableGUI context;
    public BtnAddVegetableNHListener(NhapHangVegetableGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(context.ds_lbl_congcu[0].getText().equals("ADD")){
                context.setNullAllInfo();
                context.lbl_id.setText("Auto Increment");
                context.ds_lbl_congcu[0].setText("ADD NEW");
                context.ds_lbl_congcu[0].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                context.ds_lbl_congcu[1].setVisible(false);
                context.ds_lbl_congcu[2].setVisible(false);
                context.ds_lbl_congcu[4].setVisible(true);
            }else if (context.checkDataInput()){
                vegetable v = new vegetable();
                v.setVegetable_Name(context.list_input_vege[0].getText());
                v.setCatagory((category) context.cb_categoryInput.getModel().getSelectedItem());
                v.setUnit(context.list_input_vege[1].getText());
                v.setAmount(context.list_input_vege[2].getText());
                v.setPrice(context.list_input_vege[3].getText());
                v.setImage("images/melon.jpg");
                boolean status = context.vegetableBLL.insertVegetable(v);
                if(status){
                    JOptionPane.showMessageDialog(null,"Add successfully","Insert",
                            JOptionPane.INFORMATION_MESSAGE);
                    context.setNullAllInfo();
                    context.ds_lbl_congcu[0].setText("ADD");
                    context.ds_lbl_congcu[0].setBorder(null);
                    context.ds_lbl_congcu[1].setVisible(true);
                    context.ds_lbl_congcu[2].setVisible(true);
                    context.ds_lbl_congcu[4].setVisible(false);
                    Object category = context.getCateFilter();
                    List list = context.vegetableBLL.loadVegetable(category);
                    Object[][] data = context.vegetableBLL.convertListTable(list);
                    context.loadVegetable(data);
                }else{
                    JOptionPane.showMessageDialog(null,"Add failure","Insert",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
    }
}
