package com.Rental.DaoImplement;

import com.Rental.Dao.RequestDAO;
import com.Rental.Entities.Request;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RequestDAOImpl implements RequestDAO {
    private final SessionFactory sessionFactory;

    public RequestDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Request findById(long id) {
        Session session = sessionFactory.openSession();
        Request request = session.get(Request.class, id);
        session.close();
        return request;
    }

    @Override
    public void save(Request request) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(request);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Request request) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(request);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Request request) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(request);
        transaction.commit();
        session.close();
    }
}
