package com.Rental.Entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    
    @ManyToOne(cascade = CascadeType.ALL) // Cascade changes to Landlord entity
    @JoinColumn(name = "Landlord_Id")
    private Landlord landlordId;
    
    @Column(name = "Living_in_the_flat_for")
    private Date livingInFlatFor;

	public Tenant(long tenantId, String firstName, String lastName, String email, Long contactInfo, Landlord landlordId,
			Date livingInFlatFor) {
		super();
		this.tenantId = tenantId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactInfo = contactInfo;
		this.landlordId = landlordId;
		this.livingInFlatFor = livingInFlatFor;
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
	                ", livingInFlatFor=" + livingInFlatFor +
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
		return livingInFlatFor;
	}

	public void setLivingInFlatFor(Date livingInFlatFor) {
		this.livingInFlatFor = livingInFlatFor;
	}
    
}



   

