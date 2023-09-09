
package GUI;

import DAL.category;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;

public class BtnDeleteCategoryNHListener extends MouseAdapter {
    NhapHangCategoryGUI context;
    public BtnDeleteCategoryNHListener(NhapHangCategoryGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int i=context.table_category.getSelectedRow();
        if(i<0){
            JOptionPane.showMessageDialog(null, "Please choose category from the table!");
        }else{
            int dialog_del = JOptionPane.showConfirmDialog(null,
                "Do you want to delete category?\n"+"ID: "+
                context.table_category.getValueAt(i,0)
                +"\n"+"Name: "+ context.table_category.getValueAt(i,1),"Delete",
                JOptionPane.YES_NO_OPTION);
            if(dialog_del == JOptionPane.YES_OPTION){
                int id = (int) context.table_category.getValueAt(i,0);
                category c = context.categoryBLL.getCategory(id);
                boolean status = context.categoryBLL.deleteCategory(c);
                if(status){
                    JOptionPane.showMessageDialog(null,"Delete successfully","Delete",
                            JOptionPane.INFORMATION_MESSAGE);
                    context.setNullAllInfo();  
                    List list = context.categoryBLL.loadCategory();
                    Object[][] data = context.categoryBLL.convertListTable(list); 
                    context.loadCategory(data);
                }else{
                    JOptionPane.showMessageDialog(null,"Delete failure","Delete",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
