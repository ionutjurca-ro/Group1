package dataAccessLayer.persistanceLayer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GenericDao<T> {
    Session session;
    Transaction transaction;

    public void addObject(T object) {
        try {
            startOperation();
            session.save(object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateObject(T object) {
        try {
            startOperation();
            session.update(object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<T> findAll(T object) {
        List<T> list = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + object.getClass().getName());
            list = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    public T findObjectById(T object, int id) {
        List<T> list = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + object.getClass().getName() + "WHERE id = '" + id + "'");
            list = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list.get(0);
    }

    public void deleteObject(T object) {
        try {
            startOperation();
            session.delete(object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void startOperation() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        this.session = sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
    }
}
