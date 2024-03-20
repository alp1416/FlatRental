package com.Rental.Flat_Rental_System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


import com.Rental.DaoImplement.FlatDAOImpl;
import com.Rental.DaoImplement.LandlordDAOImpl;
import com.Rental.DaoImplement.TenantDAOImpl;
import com.Rental.Entities.Flat;
import com.Rental.Entities.Landlord;
import com.Rental.Entities.Tenant;
import com.util.Helper;


public class Main {
	Helper h = new Helper();
    public static void main(String[] args) {
    	
        Main m = new Main();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = 0;
        do {
            System.out.println("Welcome to Flat Rental Management System");
            System.out.println();
            System.out.println("Press 1 to log as Admin");
            System.out.println("Press 2 to log as Landlord");
            System.out.println("Press 3 to log as Tenant");
            System.out.println("Press 4 to close the program");

            try {
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        System.out.println("Logging in as Admin...");
                        m.admin(reader);
                        break;
                    case 2:
                        System.out.println("Logging in as Landlord...");
                        m.landlord(reader);
                        break;
                    case 3:
                        System.out.println("Logging in as Tenant...");
                        m.tenant(reader);
                        break;
                    case 4:
                        System.out.println("Closing the program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
            }

        } while (choice != 4);
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void admin(BufferedReader reader) {
    	h.adminLogin(reader);

        int choice;
        try {
            do {
                System.out.println("Press 1 to See Landlord");
                System.out.println("Press 2 to See Flats");
                System.out.println("Press 3 to See Tenant");
                System.out.println("Press 4 to Add a new Landlord");
                System.out.println("Press 5 to Delete a Landlord");
                System.out.println("Press 6 to go to the  previous menu");
                System.out.println("Press 7 to return to main menu");

                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        System.out.println("Viewing Landlords...\n\n\n");
                        LandlordDAOImpl landlord = new LandlordDAOImpl();
                        landlord.printAllLandlords( landlord.getAllLandlords());
                        break;
                    case 2:
                        System.out.println("Viewing Flats...\n\n\n");
                        FlatDAOImpl flat = new FlatDAOImpl();
                        flat.printAllFlats(flat.getAllFlats());
                        break;
                    case 3:
                        System.out.println("Viewing Tenants...");
                        TenantDAOImpl tenant = new TenantDAOImpl();
                        tenant.printAllTenants(tenant.getAllTenants());
                        break;
                    case 4:
                        System.out.println("Adding a new Landlord...\n\n\n");
                          h.addNewLandlord(reader);
                        
                        break;
                        
                    case 5:
                        System.out.println("Delete a Landlord...");
                        long id;
                        System.out.println("Enter the landlord id you want to delete");
                        try {
                            id = Long.parseLong(reader.readLine());
                            LandlordDAOImpl landlord1 = new LandlordDAOImpl();
                            landlord1.deleteLandlord(id);
                            System.out.println("landlord id:"+id+"Successfully Deleted");
                           
                        } catch (NumberFormatException | IOException e) {
                            System.out.println("Invalid input. Please enter a valid long value.");
                            // Handle the error or prompt the user to enter the value again
                        }
                        
                        break;
                     
                    case 6:
                        System.out.println("Returning to previous menu...\n\n\n");
                        break;
                        
                    case 7:
                        System.out.println("Returning to main menu...\n\n\n");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice!=7);
        } catch (IOException e) {
            System.out.println("Error reading input. Please try again.");
        }
    }

    public void landlord(BufferedReader reader) {
    	
    	long id =h.landlordLogin(reader);
    	if(id == -1) {
    		System.out.println("Login fail");
    		return;}
        int choice;
        try {
            do {
            	System.out.println("Press 1 to View your profile");
                System.out.println("Press 2 to View Flats under you ");
                System.out.println("Press 3 to View Tenant under you");
                System.out.println("Press 4 to Add a new Tenant");
                System.out.println("Press 5 to Delete a Tenant");
                System.out.println("Press 6 to Add a new Flat");
                System.out.println("Press 7 to Delete a Flat");
                System.out.println("Press 8 to Return to previous menu");
                System.out.println("Press 9 to Return to Main menu");
                

                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                	case 1:
                		// View your profile
                	    System.out.println("Your Profile:");
                	    LandlordDAOImpl landlord = new LandlordDAOImpl();
                	    	Landlord l2 =landlord.getLandlordById(id); 
                	    if (landlord != null) {
                	        System.out.println("Landlord ID: " + l2.getLandlordId());
                	        System.out.println("First Name: " + l2.getFirstName());
                	        System.out.println("Last Name: " + l2.getLastName());
                	        System.out.println("Email: " + l2.getEmail());
                	        System.out.println("Contact Info: " + l2.getContactInfo());
                	        System.out.println("Joining Date: " + l2.getJoiningDate());
                	        System.out.println("\n\n\n");
                	    }
                	    break;
                
                	case 2:
                        // View flats under Landlord
                        System.out.println("Flats Owned by You:");
                        FlatDAOImpl flat1 = new FlatDAOImpl();
                        List<Flat> flats = flat1.getFlatsByLandlordId(id); 
                        if (flats != null && !flats.isEmpty()) {
                            for (Flat flat : flats) {
                                System.out.println("Flat ID: " + flat.getFlatId());
                                System.out.println("Flat Details: " + flat.getFlatDetails());
                                System.out.println("Rent Amount: " + flat.getRentAmount());
                                System.out.println("Vacant: " + flat.isVacant());
                                System.out.println("Applied: " + flat.isApplied());
                                System.out.println("---------------------------\n\n\n");
                            }
                        } else {
                            System.out.println("No flats owned by you found.");
                        }
                        break;
                      
                    case 3:
                    	System.out.println("Your Tenant\n\n\n");
                    	TenantDAOImpl t1 = new TenantDAOImpl();
                    	List<Tenant> tenants = t1.getTenantsByLandlordId(id);

                    	if (tenants != null && !tenants.isEmpty()) {
                    	    System.out.println("Tenants under Landlord ID " + id + ":");
                    	    for (Tenant tenant : tenants) {
                    	        System.out.println("Tenant ID: " + tenant.getTenantId());
                    	        System.out.println("Name: " + tenant.getFirstName() + " " + tenant.getLastName());
                    	        // Display other tenant information as needed
                    	    }
                    	} else {
                    	    System.out.println("No tenants found for Landlord ID " + id);
                    	}
                        
                        break;
                        
                    case 4:
                        System.out.println("Enter a New Tenant...\n\n\n");
                        LandlordDAOImpl landlord1 = new LandlordDAOImpl();
                        h.addNewTenant(reader,landlord1.getLandlordById(id));
                        break;
                        
                    case 5:System.out.println("Deleting the tenant");
                    		TenantDAOImpl t2 = new TenantDAOImpl();
                		List<Tenant> tenants1 = t2.getTenantsByLandlordId(id);

                		if (tenants1 != null && !tenants1.isEmpty()) {
                	    System.out.println("Tenants under Landlord ID " + id + ":");
                	    for (Tenant tenant : tenants1) {
                	        System.out.println("Tenant ID: " + tenant.getTenantId());
                	        System.out.println("Name: " + tenant.getFirstName() + " " + tenant.getLastName());
                	        // Display other tenant information as needed
                	    }
                		} else {
                	    System.out.println("No tenants found for Landlord ID " + id);
                		}
                		long id2;
                        System.out.println("Enter the landlord id you want to delete");
                        try {
                            id2 = Long.parseLong(reader.readLine());
                            TenantDAOImpl tenant = new TenantDAOImpl();
                            Tenant passtenant = tenant.findById(id2);
                            tenant.delete(passtenant);
                            System.out.println("landlord id:"+id+"Successfully Deleted");
                           
                        } catch (NumberFormatException | IOException e) {
                            System.out.println("Invalid input. Please enter a valid long value.");
                            // Handle the error or prompt the user to enter the value again
                        }
                        
                    case 6:
                        System.out.println("Adding a new Flat...\n\n\n");
                        // Add logic to add a new flat
                        break;
                        
                    case 7:
                       
                        //deleting a flat
                        break;
                        
                    case 8:
                        System.out.println("Returning to previous menu\n\n\n");
                        break;
                        
                    case 9:
                        System.out.println("Returning to main menu...\n\n\n");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 9);
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error reading input. Please try again.");
        }
    }

  public void tenant(BufferedReader reader) {

	  long id = h.tenantLogin(reader);
  		if(id == -1) {
  		System.out.println("Login fail");
  		return;
  		}
    	
        int choice;
        try {
            do {
            	System.out.println("Press 1 to View your profile");
                System.out.println("Press 2 to View Rent Due");
                System.out.println("Press 3 to Return to previous menu");
                System.out.println("Press 4 to Return to main menu");

                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                
                	case 1:
                		System.out.println("Going to you profile.../n/n/n");
                		// View your profile
                	    System.out.println("Your Profile:");
                	    TenantDAOImpl tenant = new TenantDAOImpl();
                	    	Tenant t2 =tenant.findById(id);
                	    if (t2 != null) {
                	        System.out.println("Landlord ID: " + t2.getLandlordId());
                	        System.out.println("First Name: " + t2.getFirstName());
                	        System.out.println("Last Name: " + t2.getLastName());
                	        System.out.println("Email: " + t2.getEmail());
                	        System.out.println("Contact Info: " + t2.getContactInfo());
                	        System.out.println("Joining Date: " + t2.getLivingInFlatFor());
                	        System.out.println("\n\n\n");
                	    }
                	   
                		break;
                    
                        
                       
                        
                    case 2:
                        System.out.println("Returning to previous menu.../n/n/n");
                        
                        break;
                    case 3:
                        System.out.println("Returning to main menu...\n\n\n");
                        break;
                        
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 4);
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error reading input. Please try again.");
        }
    }


   

	 

}// End of class
