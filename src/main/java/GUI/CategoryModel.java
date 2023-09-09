
package GUI;

import DAL.category;
import javax.swing.DefaultComboBoxModel;

public class CategoryModel extends DefaultComboBoxModel<category>{
    
    public CategoryModel(category[] listCate)
    {
        super(listCate);
    }
}
