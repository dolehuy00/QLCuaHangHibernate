/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.HibernateUtils;
import DAL.customerDAL;
import DAL.customers;
import java.util.List;

/**
 *
 * @author PC
 */
public class customerBLL {
    private customerDAL customerDAL;

    public customerBLL(){
        customerDAL = new customerDAL();
    }
    public List loadCustomers(){
        List list;
        list = customerDAL.loadCustomers();
        return list;   
    }
    public customers[] convertListComboBox(List<customers> list){
        int rows = list.size();
        customers[] newList = new customers[rows];
        for(int i = 0; i < rows; i++){
            newList[i] = list.get(i);    
        }
        return newList;
    }
    public Object[][] converCustomers(List<customers> list){
      int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++){
            obj[i][0] = list.get(i).getCustomerID();
            obj[i][1] = list.get(i).getPassword();
            obj[i][2] = list.get(i).getFullname();
            obj[i][3] = list.get(i).getAddress();
            obj[i][4] = list.get(i).getCity();
        }
        return obj;
    }
    public boolean isInteger(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        } 
    }
    public boolean isFloat(String str) {
        try {
            Float.valueOf(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        } 
    }
    public boolean updateCustomers(customers c){
        return customerDAL.updateCustomers(c);
    }
    
    public boolean deleteCustomers(customers c){
        return customerDAL.deleteCustomers(c);
    }
    
    public boolean AddCustomers(customers c){
        return customerDAL.addCustomers(c);
    }
    
    public customers getCustomers(int id){
        return customerDAL.getCustomers(id);
    }
    
    public List searchCustomers(String Fullname){
        return customerDAL.searchCustomersFullname(Fullname);
    }
}
