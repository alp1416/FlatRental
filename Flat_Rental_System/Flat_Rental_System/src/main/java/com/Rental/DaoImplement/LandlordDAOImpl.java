package com.Rental.DaoImplement;


import com.Rental.Dao.LandlordDAO;
import com.Rental.Entities.Landlord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LandlordDAOImpl implements LandlordDAO {

    private SessionFactory sessionFactory;

    public LandlordDAOImpl() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public void addLandlord(Landlord landlord) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(landlord);
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
    public Landlord getLandlordById(long id) {
        Session session = sessionFactory.openSession();
        Landlord landlord = null;
        try {
            landlord = session.get(Landlord.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return landlord;
    }

    @Override
    public List<Landlord> getAllLandlords() {
        Session session = sessionFactory.openSession();
        List<Landlord> landlords = null;
        try {
            landlords = session.createQuery("from Landlord", Landlord.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return landlords;
    }

    @Override
    public void updateLandlord(Landlord landlord) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(landlord);
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
    public void deleteLandlord(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Landlord landlord = session.get(Landlord.class, id);
            if (landlord != null) {
                session.delete(landlord);
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

    @Override
    public void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
