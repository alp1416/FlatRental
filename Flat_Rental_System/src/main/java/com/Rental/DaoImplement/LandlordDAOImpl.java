package com.Rental.DaoImplement;

import java.text.SimpleDateFormat;
import com.Rental.Dao.LandlordDAO;
import com.Rental.Entities.Flat;
import com.Rental.Entities.Landlord;
import com.Rental.Entities.Tenant;
import com.util.FactoryProvider;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class LandlordDAOImpl implements LandlordDAO {

    private SessionFactory sessionFactory;

    public LandlordDAOImpl() {

    	
         sessionFactory = FactoryProvider.getSessionFactory();
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
    public  Landlord getLandlordById(long id) {
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
    public  void updateLandlord(Landlord landlord) {
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
    public  void deleteLandlord(long id) {
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
        public void addTenantToFlat(long flatId, Tenant tenant) {
            Session session = sessionFactory.openSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                // Retrieve the flat by its ID
                Flat flat = session.get(Flat.class, flatId);
                
                List<Flat> flats = new ArrayList<>();
                // Add Flat objects to the list
                flats.add(flat);
                

                // Set the tenant to the flat
                tenant.setFlatId(flats);

                // Save the tenant
                session.save(tenant);

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
        }

    public  void printAllLandlords(List<Landlord> landlords) {
        if (landlords != null && !landlords.isEmpty()) {
            System.out.println("List of Landlords:");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-15s | %-15s | %-30s | %-30s | %-15s | %-15s |\n", "ID", "First Name", "Last Name", "Address", "Email", "Contact Info", "Joining Date");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (Landlord landlord : landlords) {
                System.out.printf("| %-10d | %-15s | %-15s | %-30s | %-30s | %-15s | %-15s |\n", 
                                      landlord.getLandlordId(), landlord.getFirstName(), landlord.getLastName(),
                                      landlord.getAddress(), landlord.getEmail(), landlord.getContactInfo(),
                                      dateFormat.format(landlord.getJoiningDate()));
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("No landlords found.");
        }
    }
}
   

