package com.Rental.Entities;

//Importing the package for using hibernate annotations
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//Creating a Entity class
@Entity
//Setting the table name as "Admin"
@Table(name="Admin")
public class Admin {
	
	//Declaring the field in the entity class
	
	

	@Id
	//automating the generation of id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    @Column(name = "Admin_ID")
    private long adminId;
	
    @Column(name = "Username")
    private String username;
	
    @Column(name = "Password")
    private String password;
    
    //Constructor
    public Admin(long adminId, String username, String password) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
	}
    //Constructor
    public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    //Setting the setter and getter function for the fields.

 
	public long getAdminId() {
        return adminId;
    }

   
	public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
//End of the Admin class

