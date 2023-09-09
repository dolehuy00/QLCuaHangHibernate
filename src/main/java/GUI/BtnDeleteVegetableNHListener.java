
package GUI;

import DAL.vegetable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;

public class BtnDeleteVegetableNHListener extends MouseAdapter {
    NhapHangVegetableGUI context;
    public BtnDeleteVegetableNHListener(NhapHangVegetableGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int i=context.table_vege.getSelectedRow();
        if(i<0){
            JOptionPane.showMessageDialog(null, "Please choose vegetable from the table!");
        }else{
            int dialog_del = JOptionPane.showConfirmDialog(null,
                "Do you want to delete vegetable?\n"+"ID: "+
                context.table_vege.getValueAt(i,0)
                +"\n"+"Name: "+ context.table_vege.getValueAt(i,1),"Delete",
                JOptionPane.YES_NO_OPTION);
            if(dialog_del == JOptionPane.YES_OPTION){
                int id = (int) context.table_vege.getValueAt(i, 0);
                vegetable v = context.vegetableBLL.getVegetable(id);
                boolean status = context.vegetableBLL.deleteVegetable(v);
                if(status){
                    JOptionPane.showMessageDialog(null,"Delete successfully","Delete",
                            JOptionPane.INFORMATION_MESSAGE);
                    context.setNullAllInfo();
                    Object category = context.getCateFilter();
                    List list = context.vegetableBLL.loadVegetable(category);
                    Object[][] data = context.vegetableBLL.convertListTable(list);
                    context.loadVegetable(data);
                }else{
                    JOptionPane.showMessageDialog(null,"Delete failure","Delete",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
