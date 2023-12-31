/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author DELL
 */
@Data
@Entity
@Table
public class category { 
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CatagoryID;
    @Column
    private String Name;
    @Column
    private String Description;
    @OneToMany (mappedBy = "catagory")  
    private List<vegetable> listVegetable;
    @Override
    public String toString()
    {
        return this.Name;
    }
}
