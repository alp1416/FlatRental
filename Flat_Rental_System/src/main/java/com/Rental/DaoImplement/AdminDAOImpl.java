package com.Rental.DaoImplement;


import com.Rental.Dao.AdminDAO;
import com.Rental.Entities.Admin;
import com.util.FactoryProvider;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class AdminDAOImpl implements AdminDAO {
	 private SessionFactory sessionFactory;

    public AdminDAOImpl() {
    	
        sessionFactory = FactoryProvider.getSessionFactory();
	}

	@Override
    public Admin findById(long id) {
        Session session = sessionFactory.openSession();
        Admin admin = session.get(Admin.class, id);
        session.close();
        return admin;
    }
    
    @Override
    public void saveAdmin(Admin admin) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(admin);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
        

    @Override
    public void update(Admin admin) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(admin);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Admin admin) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(admin);
        transaction.commit();
        session.close();
    }
    
    

}
