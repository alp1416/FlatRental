package com.Rental.Flat_Rental_System;

import java.util.Date;

import com.Rental.DaoImplement.AdminDAOImpl;
import com.Rental.DaoImplement.FlatDAOImpl;
import com.Rental.DaoImplement.LandlordDAOImpl;
import com.Rental.Entities.*;




public class App {
	
	 public void insertAdminData() {
       Admin admin1 = new Admin();
       admin1.setname("Admin");
       admin1.setPassword("Hello");
       AdminDAOImpl a = new AdminDAOImpl();
       a.saveAdmin(admin1);
	 }
    public void insertLandlordData() {
        
    	// Creating sample Landlords
        Landlord landlord1 = new Landlord();
        landlord1.setFirstName("John");
        landlord1.setLastName("Doe");
        landlord1.setAddress("123 Main Street");
        landlord1.setEmail("john.doe@example.com");
        landlord1.setContactInfo(1234567890L);
        landlord1.setJoiningDate(new Date());
        landlord1.setPassword("Hello");
        LandlordDAOImpl l = new LandlordDAOImpl();
        l.addLandlord(landlord1);
        
        Landlord landlord2 = new Landlord();
        landlord2.setFirstName("Jane");
        landlord2.setLastName("Smith");
        landlord2.setAddress("456 Elm Street");
        landlord2.setEmail("jane.smith@example.com");
        landlord2.setContactInfo(9876543210L);
        landlord2.setJoiningDate(new Date());
        landlord2.setPassword("World");

        LandlordDAOImpl l2 = new LandlordDAOImpl();
        l2.addLandlord(landlord2);



        Landlord landlord3 = new Landlord();
        landlord3.setFirstName("Michael");
        landlord3.setLastName("Brown");
        landlord3.setAddress("789 Oak Avenue");
        landlord3.setEmail("michael.brown@example.com");
        landlord3.setContactInfo(5556667777L);
        landlord3.setJoiningDate(new Date());
        landlord3.setPassword("Welcome123");

        LandlordDAOImpl l3 = new LandlordDAOImpl();
        l3.addLandlord(landlord3);}
    
    public void insertflatData() {
        
        //Adding sample Flats
        
        Flat flat1 = new Flat();
        
        flat1.setFlatDetails("1 Bedroom Apartment");
        flat1.setRentAmount(1000.00);
        flat1.setVacant(true);
        flat1.setApplied(false);
        
        FlatDAOImpl f1 = new FlatDAOImpl();
        f1.addFlat(flat1);


        Flat flat2 = new Flat();
        LandlordDAOImpl l1 = new LandlordDAOImpl();
        
        flat2.setFlatDetails("2 Bedroom Apartment");
        flat2.setRentAmount(1500.00);
        flat2.setVacant(true);
        flat2.setApplied(false);
        flat2.setLandlordId(l1.getLandlordById(12));
        
        
        f1.addFlat(flat2);

        Flat flat3 = new Flat();
       
        flat3.setFlatDetails("Studio Apartment");
        flat3.setRentAmount(800.00);
        flat3.setVacant(true);
        flat3.setApplied(false);
        flat3.setLandlordId(l1.getLandlordById(12));
        
        f1.addFlat(flat3);


        Flat flat4 = new Flat();
        
        flat4.setFlatDetails("3 Bedroom House");
        flat4.setRentAmount(2000.00);
        flat4.setVacant(true);
        flat4.setApplied(false);
        flat4.setLandlordId(l1.getLandlordById(12));
        
      
        f1.addFlat(flat4);

        Flat flat5 = new Flat();
        
        flat5.setFlatDetails("1 Bedroom Condo");
        flat5.setRentAmount(1200.00);
        flat5.setVacant(true);
        flat5.setApplied(true);
        
        FlatDAOImpl f5 = new FlatDAOImpl();
        f5.addFlat(flat5);


        Flat flat6 = new Flat();
        
        flat6.setFlatDetails("2 Bedroom Townhouse");
        flat6.setRentAmount(1800.00);
        flat6.setVacant(true);
        flat6.setApplied(false);
        
        FlatDAOImpl f6 = new FlatDAOImpl();
        f6.addFlat(flat6);

        Flat flat7 = new Flat();
      
        flat7.setFlatDetails("Studio Loft");
        flat7.setRentAmount(900.00);
        flat7.setVacant(false);
        flat7.setApplied(false);
        
        FlatDAOImpl f7 = new FlatDAOImpl();
        f7.addFlat(flat7);

        Flat flat8 = new Flat();
       
        flat8.setFlatDetails("4 Bedroom Penthouse");
        flat8.setRentAmount(3000.00);
        flat8.setVacant(true);
        flat8.setApplied(true);
        
//        FlatDAOImpl f8 = new FlatDAOImpl();
//        f8.addFlat(flat8);
//        public void insertTenantData() {
//        	
//        	}
}
}