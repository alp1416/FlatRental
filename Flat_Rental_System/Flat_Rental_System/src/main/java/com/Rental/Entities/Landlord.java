package com.Rental.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Landlord")
public class Landlord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Landlord_Id")
    private long landlordId;
    
    @Column(name = "First_Name")
    private String firstName;
    
    @Column(name = "Last_Name")
    private String lastName;
    
    @Column(name = "Address")
    private String address;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "Contact_Info")
    private Long contactInfo;
    
    @Column(name = "Joining_Date")
    private Date joiningDate; 
    
    @OneToMany(mappedBy = "landlordId", cascade = CascadeType.ALL) 
    private List<Flat> flatId;
    
    @OneToMany(mappedBy = "landlordId", cascade = CascadeType.ALL) 
    private List<Tenant> tenantId;
    
    public Landlord() {}
    
    

    public Landlord(long landlordId, String firstName, String lastName, String address, String email, Long contactInfo,
			Date joiningDate, List<Flat> flatId, List<Tenant> tenantId) {
		super();
		this.landlordId = landlordId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.contactInfo = contactInfo;
		this.joiningDate = joiningDate;
		this.flatId = flatId;
		this.tenantId = tenantId;
	}

    @Override
    public String toString() {
        return "Landlord{" +
                "landlordId=" + landlordId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contactInfo=" + contactInfo +
                ", joiningDate=" + joiningDate +
                '}';
    }


	// Getters and setters


	public long getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(long landlordId) {
		this.landlordId = landlordId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
}
