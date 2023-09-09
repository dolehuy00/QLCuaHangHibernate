
package DAL;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class vegetableDAL {
    
    Session session = HibernateUtils.getSessionFactory().openSession();
 
    public vegetableDAL(){
        this.session = session;
    }
    
    public vegetable getVegetable(int vegetableID){
        vegetable v;
        session.beginTransaction();
        v = session.get(vegetable.class, vegetableID);
        session.getTransaction().commit();
        return v;    
    }
    
    public List loadVegetable() {
        List<vegetable> list;
        Transaction transaction = session.beginTransaction();
        list = session.createQuery("FROM vegetable", vegetable.class).list();
        transaction.commit();
        return list;    
    }
    
    public List loadVegetableInCategory(int cateID){
        List list;
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("FROM vegetable WHERE CatagoryID = ?1");
        q.setParameter(1, cateID);
        list = q.list();
        transaction.commit();
        return list;
    }
    public boolean addVegetable(vegetable v){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(v);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return transaction.getStatus().isOneOf(TransactionStatus.COMMITTED);
    }
    
    public boolean updateVegetable(vegetable v){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(v);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return transaction.getStatus().isOneOf(TransactionStatus.COMMITTED);
    }
    
    public boolean deleteVegetable(vegetable v){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(v);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return transaction.getStatus().isOneOf(TransactionStatus.COMMITTED);
    }
    
    public List searchVegetableName(String name){
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM vegetable where Vegetable_Name like ?1");
        query.setParameter(1, "%"+name+"%");
        List<vegetable> list = query.list();
        transaction.commit();
        return list;
    }
    public List searchVegetableNameInCategory(String name, int id){
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(
            "FROM vegetable where Vegetable_Name like ?1 and CatagoryID = ?2");
        query.setParameter(1, "%"+name+"%");
        query.setParameter(2, id);
        List<vegetable> list = query.list();
        transaction.commit();
        return list;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public static void main(String args[]){
//        vegetableDAL dal = new vegetableDAL();
//        Vegetable obj = dal.getVegetable(1);
//        System.out.println(obj.getVegetableName());
//        List list = dal.getVegetableInCategory(1);
//        for (Iterator iterator = list.iterator(); iterator.hasNext();){
//             vegetable v = (vegetable) iterator.next(); 
//             System.out.print("ID: " + v.getVegetableID()); 
//             System.out.print("Name: " + v.getVegetable_Name()); 
//             
//          } 
//    }
}
