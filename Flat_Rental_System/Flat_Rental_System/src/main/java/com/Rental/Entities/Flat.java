package com.Rental.Entities;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Flat")
public class Flat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Flat_Id")
    private long flatId;
    
    @Column(name = "Flat_Details")
    private String flatDetails;
    
    @Column(name = "Rent_Amount")
    private double rentAmount;
    
    @Column(name = "Vacant")
    private boolean vacant;
    
    @Column(name = "Applied")
    private boolean applied;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Landlord_Id")
    private Landlord landlordId;
    
    @OneToOne
    @JoinColumn(name = "Request_Id")
    private Request requestId;
    
    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "Rent_due_Id")
    private RentDue rentDueId;
    
    //Constructors
    public Flat() {}
    
	public Flat(long flatId, String flatDetails, double rentAmount, boolean vacant, boolean applied,
			Landlord landlordId, Request requestId, RentDue rentDueId) {
		super();
		this.flatId = flatId;
		this.flatDetails = flatDetails;
		this.rentAmount = rentAmount;
		this.vacant = vacant;
		this.applied = applied;
		this.landlordId = landlordId;
		this.requestId = requestId;
		this.rentDueId = rentDueId;
	}
	//To String method
	@Override
	public String toString() {
	    return "Flat{" +
	            "flatId=" + flatId +
	            ", flatDetails='" + flatDetails + '\'' +
	            ", rentAmount=" + rentAmount +
	            ", vacant=" + vacant +
	            ", applied=" + applied +
	            ", landlordId=" + (landlordId != null ? landlordId.getLandlordId() : "null") +
	            ", requestId='" + requestId.getRequestId() + '\'' +
	            ", rentDueId=" + (rentDueId != null ? rentDueId.getRentDueId() : "null") +
	            '}';
	}

    
    

    // Getters and setters

	public long getFlatId() {
		return flatId;
	}

	public void setFlatId(long flatId) {
		this.flatId = flatId;
	}

	public String getFlatDetails() {
		return flatDetails;
	}

	public void setFlatDetails(String flatDetails) {
		this.flatDetails = flatDetails;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public boolean isVacant() {
		return vacant;
	}

	public void setVacant(boolean vacant) {
		this.vacant = vacant;
	}

	public boolean isApplied() {
		return applied;
	}

	public void setApplied(boolean applied) {
		this.applied = applied;
	}

	public Landlord getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(Landlord landlordId) {
		this.landlordId = landlordId;
	}

	public Request getRequestId() {
		return requestId;
	}

	public void setRequestId(Request requestId) {
		this.requestId = requestId;
	}

	public RentDue getRentDueId() {
		return rentDueId;
	}

	public void setRentDueId(RentDue rentDueId) {
		this.rentDueId = rentDueId;
	}
}

