/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author PC
 */

@Data
@Entity
@Table
public class customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CustomerID;
    @Column
    private String Password;
    @Column
    private String Fullname;
    @Column
    private String Address;
    @Column
    private String City;
    @Override
    public String toString(){
        return this.Fullname;
    }
    
}
