
package DAL;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class categoryDAL {
    Session session = HibernateUtils.getSessionFactory().openSession();
    public categoryDAL() {
        this.session = session;
    }
    public List loadCategory() {
        List<category> list;
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        list = session.createQuery("FROM category", category.class).list();
        transaction.commit();
        return list;

    }
    public List searchCategoryName(String name){
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM category where name like ?1");
        query.setParameter(1, "%"+name+"%");
        List<category> list = query.list();
        transaction.commit();
        return list;
    }
    public category getCategory(int CategoryID){
        category c = session.get(category.class, CategoryID);
        return c;
    }
    public boolean updateCategory(category c){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(c);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return transaction.getStatus().isOneOf(TransactionStatus.COMMITTED);
    }
    public boolean deleteCategory(category c){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(c);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return transaction.getStatus().isOneOf(TransactionStatus.COMMITTED);
    }
    public boolean addCategory(category c){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(c);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return transaction.getStatus().isOneOf(TransactionStatus.COMMITTED);
    }
}
