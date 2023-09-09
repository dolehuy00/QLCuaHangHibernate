
package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class BtnSearchCategoryNHListener extends MouseAdapter {
    NhapHangCategoryGUI context;
    public BtnSearchCategoryNHListener(NhapHangCategoryGUI context) {
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        String name = context.input_search.getText();
        List list = context.categoryBLL.searchCategory(name);
        Object[][] data = context.categoryBLL.convertListTable(list); 
        context.loadCategory(data);
    }
}
