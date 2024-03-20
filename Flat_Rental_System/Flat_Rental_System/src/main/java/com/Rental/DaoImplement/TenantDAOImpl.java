package com.Rental.DaoImplement;

import com.Rental.Dao.TenantDAO;
import com.Rental.Entities.Tenant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TenantDAOImpl implements TenantDAO {
    private final SessionFactory sessionFactory;

    public TenantDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Tenant findById(long id) {
        Session session = sessionFactory.openSession();
        Tenant tenant = session.get(Tenant.class, id);
        session.close();
        return tenant;
    }

    @Override
    public void save(Tenant tenant) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(tenant);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Tenant tenant) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(tenant);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Tenant tenant) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(tenant);
        transaction.commit();
        session.close();
    }
}
