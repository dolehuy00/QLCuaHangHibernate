

package BLL;

import DAL.HibernateUtils;
import DAL.OrderVegetable;
import DAL.order;
import DAL.orderDAL;
import DAL.vegetable;
import java.util.List;

public class orderBLL {
    private orderDAL orderDAL;
    public orderBLL(){
         orderDAL = new orderDAL();
    }
    
    public List loadOrder(){
        List list;
        list = orderDAL.loadOrder();
        return list;   
    }
    
    public Object[][] convertListTableOrder(List<order> list){
        int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++){
            obj[i][0] = list.get(i).getOrderID();
            obj[i][1] = list.get(i).getCustomer();
            obj[i][2] = list.get(i).getDate();
            obj[i][3] = list.get(i).getTotal();
            obj[i][4] = list.get(i).getNote();
        }
        return obj;
    }
    
    public Object[][] convertListVegetableInOrder(List<OrderVegetable> list){
        int rows = list.size();
        int cols = 8;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++){
            obj[i][0] = i+1;
            if (list.get(i).getVegetable()!=null) {
                obj[i][1] = list.get(i).getVegetable().getVegetableID();
                obj[i][2] = list.get(i).getVegetable().getVegetable_Name();
                obj[i][4] = list.get(i).getVegetable().getUnit();
                obj[i][5] = list.get(i).getVegetable().getPrice();
            } else {
                obj[i][2] = "Null";
                obj[i][1] = list.get(i).getVegetable();
            }
            obj[i][3] = list.get(i).getQuantity(); 
            obj[i][6] = list.get(i).getPrice();
            obj[i][7] = "Delete";
        }
        return obj;
    }
    
    public Object[][] convertListSearchVe(List<vegetable> list){
        int rows = list.size();
        int cols = 6;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++){
            obj[i][0] = list.get(i).getVegetableID();
            obj[i][1] = list.get(i).getVegetable_Name();
            obj[i][2] = list.get(i).getPrice();
            obj[i][3] = list.get(i).getUnit();
            obj[i][4] = "1";
            obj[i][5] = "Add";
        }
        return obj;
    }

    public order getOrder(int OrderID){
        order o = orderDAL.getOrder(OrderID);
        return o;
    }
    public List searchOrder(String key){
        return orderDAL.searchOrder(key);
    }
    public boolean insertOrder(order o){
        return orderDAL.addOrder(o);
    }
    
    public boolean editOrder(order o, List l){
        return orderDAL.updateOrder(o, l);
    }


    
}
