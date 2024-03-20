package com.Rental.DaoImplement;

import com.Rental.Dao.FlatDAO;
import com.Rental.Entities.Flat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class FlatDAOImpl implements FlatDAO {

    private SessionFactory sessionFactory;

    public FlatDAOImpl() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public void addFlat(Flat flat) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(flat);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Flat getFlatById(long id) {
        Session session = sessionFactory.openSession();
        Flat flat = null;
        try {
            flat = session.get(Flat.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flat;
    }

    @Override
    public List<Flat> getAllFlats() {
        Session session = sessionFactory.openSession();
        List<Flat> flats = null;
        try {
            flats = session.createQuery("from Flat", Flat.class).list();
        } 
        
        
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flats;
    }

    @Override
    public void updateFlat(Flat flat) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(flat);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteFlat(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Flat flat = session.get(Flat.class, id);
            if (flat != null) {
                session.delete(flat);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            
        }
    }

  
    public void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
