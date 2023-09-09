/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name = "`order`")
public class order{
    private List<OrderVegetable> orderVegetable = new ArrayList<>();
    private int OrderID;
    private Date Date;
    private String Total;
    private String Note;
    private customers Customer;
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public int getOrderID() {
        return OrderID;
    }
    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }
    
    @Column
    @Temporal(value = TemporalType.DATE)
    public Date getDate() {
        return Date;
    }
    public void setDate(Date Date) {
        this.Date = Date;
    }
    @Column
    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
    @Column
    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }
    
    @ManyToOne
    @JoinColumn(name = "CustomerID")
    @NotFound(action =  NotFoundAction.IGNORE)
    public customers getCustomer() {
        return Customer;
    }

    public void setCustomer(customers Customer) {
        this.Customer = Customer;
    }
    
    @OneToMany(mappedBy = "primaryKey.order",cascade = CascadeType.ALL, fetch =FetchType.LAZY)
    public List<OrderVegetable> getOrderVegetable() {
        return orderVegetable;
    }

    public void setOrderVegetable(List<OrderVegetable> orderVegetable) {
        this.orderVegetable = orderVegetable;
    }
    

//    @ManyToMany
//    @JoinTable(name = "orderdetail", joinColumns={@JoinColumn(name = "OrderID")},
//            inverseJoinColumns = {@JoinColumn(name = "VegetableID")})
//    private List<vegetable> vegetable;

    
    
    public void addOrderVegetable(OrderVegetable orderVegetable) {
        this.orderVegetable.add(orderVegetable);
    }  

    

    

    

    
}
