/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAL.customers;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author PC
 */
public class CustomerModel extends DefaultComboBoxModel<customers>{
    
    public CustomerModel(customers[] customers)
    {
        super(customers);
    }
}
