/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class vegetable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int VegetableID;
    
    @Column 
    private String Vegetable_Name;
    @Column
    private String Unit;
    @Column
    private String Amount;
    @Column 
    private String Image;
    @Column
    private String Price;
    @ManyToOne
    @JoinColumn(name="CatagoryID")
    private category catagory;
    
    @OneToMany(mappedBy = "primaryKey.vegetable",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    private List<OrderVegetable> orderVegetables = new ArrayList<>();
    
    
  
}
