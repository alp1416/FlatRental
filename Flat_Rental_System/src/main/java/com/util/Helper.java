package com.util;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.Date;
import java.util.List;

import com.Rental.DaoImplement.AdminDAOImpl;

import com.Rental.DaoImplement.LandlordDAOImpl;
import com.Rental.DaoImplement.TenantDAOImpl;
import com.Rental.Entities.Admin;
import com.Rental.Entities.Flat;
import com.Rental.Entities.Landlord;
import com.Rental.Entities.Tenant;

public class Helper {
	 public void addNewTenant(BufferedReader reader, Landlord landlord) {
	        try {
	            // Collect tenant information from the user
	            System.out.println("Enter the tenant's first name:");
	            String firstName = reader.readLine();

	            System.out.println("Enter the tenant's last name:");
	            String lastName = reader.readLine();

	            System.out.println("Enter the tenant's email:");
	            String email = reader.readLine();

	            System.out.println("Enter the tenant's contact info:");
	            Long contactInfo = Long.parseLong(reader.readLine());

	            System.out.println("Enter the tenant's password:");
	            String password = reader.readLine();

	            // Create a new Tenant object
	            Tenant newTenant = new Tenant();
	            newTenant.setFirstName(firstName);
	            newTenant.setLastName(lastName);
	            newTenant.setEmail(email);
	            newTenant.setContactInfo(contactInfo);
	            newTenant.setPassword(password);
	            newTenant.setLandlordId(landlord);
	            Date moveInDate = new Date(); // 
	            newTenant.setMoveIn(moveInDate);

	          //Getting the list of flat under land lord
	            List<Flat> landlordFlats = landlord.getFlatId();

	            // Display flats owned by the landlord
	            System.out.println("Flats owned by You which are vacant :");
	            for (Flat flat : landlordFlats) {
	                System.out.println(flat.getFlatId() + ": " + flat.getFlatDetails());
	            }

	            // asking use select a flat to add the tenant
	            System.out.println("Enter the ID of the flat where you want to add the tenant:");
	            long flatId = Long.parseLong(reader.readLine());
	            LandlordDAOImpl l = new LandlordDAOImpl();
	            l.addTenantToFlat(flatId,newTenant);
	           
	            System.out.println("Tenant added successfully!");

	        } catch (IOException | NumberFormatException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	  public void adminLogin(BufferedReader reader) {
	        int counter = 0;
	       
			
				
	        AdminDAOImpl A = new AdminDAOImpl();

	        System.out.println("Enter your admin id without any space");

	        do {
	            try {
	                Long userEnteredUsername = Long.parseLong(reader.readLine());
	                Admin admin = A.findById(userEnteredUsername);
	                String storedPassword = admin.getPassword();

	                if (storedPassword != null) {
	                    System.out.println("Enter your Password:");
	                    String userEnteredPassword = reader.readLine();
	                    if (userEnteredPassword.equals(storedPassword)) {
	                        System.out.println("Password matched. Login successful!");
	                       
	                        return;
	                    } else {
	                        System.out.println("Password did not match! Login failed!");
	                        System.out.println("Please re-enter your Admin ID.");
	                    }
	                } else {
	                    System.out.println("Admin ID not found! Please re-enter your Admin ID.");
	                }
	            } catch (NumberFormatException | IOException e) {
	                System.out.println("Invalid input. Please enter a valid admin ID.");
	            }
	        } while (counter < 4);
	    }

	  public long landlordLogin(BufferedReader reader) {
	        int counter = 0;
	        
	        LandlordDAOImpl l1 = new LandlordDAOImpl();

	        System.out.println("Enter your landlord ID:");

	        try {
	            do {
	                try {
	                    Long landlordId = Long.parseLong(reader.readLine());

	                    Landlord landlord = l1.getLandlordById(landlordId);
	                    String storedPassword = landlord.getPassword();

	                    if (storedPassword != null) {
	                        System.out.println("Enter your password:");
	                        String userEnteredPassword = reader.readLine();

	                        if (userEnteredPassword.equals(storedPassword)) {
	                            System.out.println("Password matched. Login successful!");
	                            return landlordId;
	                        } else {
	                            System.out.println("Password did not match! Login failed!");
	                            System.out.println("Please re-enter your landlord ID.");
	                        }
	                    } else {
	                        System.out.println("Landlord ID not found! Please re-enter your landlord ID.");
	                    }
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid input. Please enter a valid landlord ID.");
	                }
	                counter++;
	            } while (counter < 3);
	        } catch (IOException e) {
	            System.out.println("Error reading input. Please try again.");
	        } 
	        return -1;
	        }
	    
	  
		  public long tenantLogin(BufferedReader reader) {
			    int counter = 0;
			    TenantDAOImpl tenantDAO = new TenantDAOImpl();

			    System.out.println("Enter your tenant ID:");

			    try {
			        do {
			            try {
			                Long tenantId = Long.parseLong(reader.readLine());

			                Tenant tenant = tenantDAO.findById(tenantId);
			                String storedPassword = tenant.getPassword();

			                if (storedPassword != null) {
			                    System.out.println("Enter your password:");
			                    String userEnteredPassword = reader.readLine();

			                    if (userEnteredPassword.equals(storedPassword)) {
			                        System.out.println("Password matched. Login successful!");
			                        // Implement the logic for logged in tenant
			                        return tenantId;
			                    } else {
			                        System.out.println("Password did not match! Login failed!");
			                        System.out.println("Please re-enter your tenant ID.");
			                    }
			                } else {
			                    System.out.println("Tenant ID not found! Please re-enter your tenant ID.");
			                }
			            } catch (NumberFormatException e) {
			                System.out.println("Invalid input. Please enter a valid tenant ID.");
			            }
			            counter++;
			        } while (counter < 3);
			    } catch (IOException e) {
			        System.out.println("Error reading input. Please try again.");
			    }
			    return -1;
			}

	   
	  public void addNewLandlord(BufferedReader reader) {
		    try {
		        System.out.println("Adding a new Landlord...");
		        
		        // Get landlord details from user input
		        System.out.print("Enter landlord's first name: ");
		        String firstName = reader.readLine();
		        
		        System.out.print("Enter landlord's last name: ");
		        String lastName = reader.readLine();
		        
		        System.out.print("Enter landlord's address: ");
		        String address = reader.readLine();
		        
		        System.out.print("Enter landlord's email: ");
		        String email = reader.readLine();
		        
		        System.out.print("Enter landlord's contact information: ");
		        Long contactInfo = Long.parseLong(reader.readLine());
		        
		        // Create a new Landlord object
		        Landlord newLandlord = new Landlord();
		        newLandlord.setFirstName(firstName);
		        newLandlord.setLastName(lastName);
		        newLandlord.setAddress(address);
		        newLandlord.setEmail(email);
		        newLandlord.setContactInfo(contactInfo);
		        newLandlord.setJoiningDate(new Date());
		        
		        // Save the new landlord to the database
		         LandlordDAOImpl landlord = new LandlordDAOImpl();
		         landlord.addLandlord(newLandlord);
		        
		        System.out.println("Landlord added successfully!");
		    } catch (IOException e) {
		        System.out.println("Error reading input. Please try again.");
		    }
		}

	

	}// End of class


