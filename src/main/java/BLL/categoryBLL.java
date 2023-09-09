

package BLL;

import DAL.HibernateUtils;
import DAL.category;
import DAL.categoryDAL;
import java.util.List;

public class categoryBLL {
    private categoryDAL categoryDAL;

    public categoryBLL(){
        categoryDAL = new categoryDAL();
    }
    
    public List loadCategory(){
        List list;
        list = categoryDAL.loadCategory();
        return list;   
    }
    
    public category[] convertListComboBox(List<category> list){
        int rows = list.size();
        category[] newList = new category[rows];
        for(int i = 0; i < rows; i++){
            newList[i] = list.get(i);    
        }
        return newList;
    }
    public Object[][] convertListTable(List<category> list){
        int rows = list.size();
        int cols = 4;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++){
            obj[i][0] = list.get(i).getCatagoryID();
            obj[i][1] = list.get(i).getName();
            obj[i][2] = list.get(i).getDescription();
            obj[i][3] = list.get(i).getListVegetable().size();
        }
        return obj;
    }
    
    public category getCategory(int CategoryID){
        category c = categoryDAL.getCategory(CategoryID);
        return c;
    }
    public List searchCategory(String name){
        return categoryDAL.searchCategoryName(name);
    }
    public boolean updateCategory(category c){
        return categoryDAL.updateCategory(c);
    }
    
    public boolean deleteCategory(category c){
        return categoryDAL.deleteCategory(c);
    }
    public boolean insertCategory(category c){
        return categoryDAL.addCategory(c);
    }
    
}
