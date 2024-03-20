package com.Rental.DaoImplement;

import com.Rental.Dao.TenantDAO;
import com.Rental.Entities.Tenant;
import com.util.FactoryProvider;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TenantDAOImpl implements TenantDAO {
    private final SessionFactory sessionFactory;

    public TenantDAOImpl() {
    	 sessionFactory =FactoryProvider.getSessionFactory(); 
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
    
    @Override
    public List<Tenant> getAllTenants() {
        Session session = sessionFactory.openSession();
        List<Tenant> tenants = null;
        try {
            tenants = session.createQuery("from Tenant", Tenant.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return tenants;
    }
    
    @Override
    public List<Tenant> getTenantsByLandlordId(long landlordId) {
        Session session = sessionFactory.openSession();
        List<Tenant> tenants = null;
        try {
            Query<Tenant> query = session.createQuery("FROM Tenant WHERE landlordId.landlordId = :landlordId", Tenant.class);
            query.setParameter("landlordId", landlordId);
            tenants = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return tenants;
    }


    @Override
    public void printAllTenants(List<Tenant> tenants) {
        if (tenants != null && !tenants.isEmpty()) {
            System.out.println("List of Tenants:");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-15s | %-15s | %-30s | %-15s | %-10s | %-10s | %-10s |\n", "Tenant ID", "First Name", "Last Name", "Email", "Contact Info", "Move-In Date", "Landlord ID", "Flat ID");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (Tenant tenant : tenants) {
                System.out.printf("| %-10d | %-15s | %-15s | %-30s | %-15d | %-10s | %-10d | %-10d |\n",
                                      tenant.getTenantId(), tenant.getFirstName(), tenant.getLastName(),
                                      tenant.getEmail(), tenant.getContactInfo(),
                                      dateFormat.format(tenant.getLivingInFlatFor()),
                                      (tenant.getLandlordId() != null ? tenant.getLandlordId().getLandlordId() : -1));
                                      
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        } else {
             System.out.println("No tenants found.");
        }
    }

}
