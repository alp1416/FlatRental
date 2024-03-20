package com.Rental.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Tenant")
public class Tenant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tenant_Id")
    private long tenantId;
    
    @Column(name = "First_Name")
    private String firstName;
    
    @Column(name = "Last_Name")
    private String lastName;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "Contact_Info")
    private Long contactInfo;
    
    @Column(name = "Password")
    private String password;
    
    @ManyToOne(cascade = CascadeType.ALL) // Cascade changes to Landlord entity
    @JoinColumn(name = "Landlord_Id")
    private Landlord landlordId;
    
    @Column(name = "Moved_In")
    @Temporal(TemporalType.DATE)
    private Date moveIn;
    
    @OneToMany(mappedBy = "tenantId", cascade = CascadeType.ALL) 
    private List<Flat> flatId;



	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public Date getMoveIn() {
		return moveIn;
	}




	public void setMoveIn(Date moveIn) {
		this.moveIn = moveIn;
	}




	public Tenant(long tenantId, String firstName, String lastName, String email, Long contactInfo, String password,
			Landlord landlordId, Date moveIn) {
		super();
		this.tenantId = tenantId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactInfo = contactInfo;
		this.password = password;
		this.landlordId = landlordId;
		this.moveIn = moveIn;
	}




	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	 @Override
	    public String toString() {
	        return "Tenant{" +
	                "tenantId=" + tenantId +
	                ", firstName='" + firstName + '\'' +
	                ", lastName='" + lastName + '\'' +
	                ", email='" + email + '\'' +
	                ", contactInfo=" + contactInfo +
	                ", landlordId=" + (landlordId != null ? landlordId.getLandlordId() : "null") +
	                ", livingInFlatFor=" + moveIn +
	                '}';
	 }
	 // Getters and setters

	public long getTenantId() {
		return tenantId;
	}

	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(Long contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Landlord getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(Landlord landlordId) {
		this.landlordId = landlordId;
	}

	public Date getLivingInFlatFor() {
		return moveIn;
	}

	public void setLivingInFlatFor(Date moveIn) {
		this.moveIn = moveIn;
	}




	public List<Flat> getFlatId() {
		return flatId;
	}




	public void setFlatId(List<Flat> flatId) {
		this.flatId = flatId;
	}
    
}



   

