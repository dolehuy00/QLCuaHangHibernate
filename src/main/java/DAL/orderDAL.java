/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 *
 * @author PC
 */

public class orderDAL {
    Session session;
    public orderDAL(){
        this.session = session;
    }
    public order getOrder(int id){
        order o;
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        o = session.get(order.class, id);
        transaction.commit();
        return o;
    }
    
    public List loadOrder(){
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List order = session.createQuery("FROM order", order.class).list();
        transaction.commit();
        return order;
    }
    
    public List searchOrder(String key){
        session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM order where customer.Fullname like ?1");
        query.setParameter(1, "%"+key+"%");
        List<order> list = query.list();
        transaction.commit();
        return list;
    }
    
    public boolean addOrder(order o){
        session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(o);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return transaction.getStatus().isOneOf(TransactionStatus.COMMITTED);
    }
    
    public boolean updateOrder(order o, List l){
        deteteAllList(o,l);
        session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(o);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return transaction.getStatus().isOneOf(TransactionStatus.COMMITTED);
    }
    
    public void deteteAllList(order o, List<OrderVegetable> l){
        session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        for (OrderVegetable l1 : l) {
            session.delete(l1);
        }
        transaction.commit();
    }
    
    
    public static void main(String[] args) {
//        order o = dal.getOrder(2);
//        customers c = o.getCustomer();
//        System.err.println("ID:"+o.getOrderID());
//        System.err.println(c.getCustomerID()+"::"+c.getFullname()+"::"+c.getAddress()+"::"+c.getCity());
//        System.err.println(o.getDate());
//        System.err.println(o.getNote());
//        System.err.println(o.getTotal());
//
//         
//        System.err.println(
//        o.getOrderVegetables().get(0).getVegetable().getVegetableID()+
//        "---"+o.getOrderVegetables().get(0).getVegetable().getVegetable_Name()+
//        "---"+o.getOrderVegetables().get(0).getPrice()+
//        "---"+o.getOrderVegetables().get(0).getQuantity());
//        
//        System.err.println(
//        o.getOrderVegetables().get(1).getVegetable().getVegetableID()+
//        "---"+o.getOrderVegetables().get(1).getVegetable().getVegetable_Name()+
//        "---"+o.getOrderVegetables().get(1).getPrice()+
//        "---"+o.getOrderVegetables().get(1).getQuantity());

//            List<order> oList = dal.searchOrder("John");
//           System.err.println(oList.get(0).getOrderID());
    }
}

