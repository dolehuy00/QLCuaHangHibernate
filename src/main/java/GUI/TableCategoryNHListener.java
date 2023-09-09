
package GUI;

import DAL.category;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableCategoryNHListener extends MouseAdapter {  
    NhapHangCategoryGUI context;
    public TableCategoryNHListener(NhapHangCategoryGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e){
        String id= context.table_category.getModel().getValueAt(
                context.table_category.getSelectedRow(),0).toString();
        category c = context.categoryBLL.getCategory(Integer.parseInt(id));
        context.lbl_id_category.setText(id);
        context.list_input_category[0].setText(c.getName());
        context.txt_description.setText(c.getDescription());
    }
}
