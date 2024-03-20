package com.Rental.DaoImplement;

import com.Rental.Dao.FlatDAO;
import com.Rental.Entities.Flat;
import com.util.FactoryProvider;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;



public class FlatDAOImpl implements FlatDAO {

    private SessionFactory sessionFactory;

    public FlatDAOImpl() {
        sessionFactory =FactoryProvider.getSessionFactory();
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
        } 
    }
    @Override
    public List<Flat> getFlatsByLandlordId(long landlordId) {
        Session session = sessionFactory.openSession();
        List<Flat> flats = null;
        try {
            Query<Flat> query = session.createQuery("FROM Flat WHERE landlordId.landlordId = :landlordId", Flat.class);
            query.setParameter("landlordId", landlordId);
            flats = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flats;
    }


        
    
    public void printAllFlats(List<Flat> flats) {
        if (flats != null && !flats.isEmpty()) {
            System.out.println("List of Flats:");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "Flat ID", "Flat Details", "Rent Amount", "Vacant", "Applied", "Landlord ID", "Request ID", "Rent Due ID");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            for (Flat flat : flats) {
                System.out.printf("| %-10d | %-30s | %-15.2f | %-10b | %-10b | %-10d | %-10d | %-10d |\n",
                                      flat.getFlatId(), flat.getFlatDetails(), flat.getRentAmount(),
                                      flat.isVacant(), flat.isApplied(),
                                      (flat.getLandlordId() != null ? flat.getLandlordId().getLandlordId() : -1),
                                      (flat.getRequestId() != null ? flat.getRequestId().getRequestId() : -1),
                                      (flat.getRentDueId() != null ? flat.getRentDueId().getRentDueId() : -1),
                                      (flat.getTenantId() != null ? flat.getTenantId().getTenantId() : -1));
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        } else {
        	 System.out.println("No flats found.");
        }
    }
}
    
    

