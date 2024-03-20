package com.Rental.DaoImplement;


import com.Rental.Dao.RentDueDAO;
import com.Rental.Entities.RentDue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RentDueDAOImpl implements RentDueDAO {
    private final SessionFactory sessionFactory;

    public RentDueDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public RentDue findById(long id) {
        Session session = sessionFactory.openSession();
        RentDue rentDue = session.get(RentDue.class, id);
        session.close();
        return rentDue;
    }

    @Override
    public void save(RentDue rentDue) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(rentDue);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(RentDue rentDue) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(rentDue);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(RentDue rentDue) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(rentDue);
        transaction.commit();
        session.close();
    }
}
