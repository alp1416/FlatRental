package com.Rental.Entities;

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
@Table(name = "Rent_due")
public class RentDue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Rent_due_Id")
    private long rentDueId;
    
    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "Flat_Id")
    private Flat flat;
    
    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "Landlord_Id")
    private Landlord landlord;
    
    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "Tenant_Id")
    private Tenant tenantId;
    
    @Column(name = "Rent_due_Amt")
    private Double rentDueAmt;

    public RentDue() {}
    
    

    public RentDue(long rentDueId, Flat flat, Landlord landlord, Tenant tenantId, Double rentDueAmt) {
		super();
		this.rentDueId = rentDueId;
		this.flat = flat;
		this.landlord = landlord;
		this.tenantId = tenantId;
		this.rentDueAmt = rentDueAmt;
	}

    @Override
    public String toString() {
        return "RentDue{" +
                "rentDueId=" + rentDueId +
                ", flat=" + (flat != null ? flat.getFlatId() : "null") +
                ", landlord=" + (landlord != null ? landlord.getLandlordId() : "null") +
                ", tenantId=" + (tenantId != null ? tenantId.getTenantId() : "null") +
                ", rentDueAmt=" + rentDueAmt +
                '}';
    }



	// Getters and setters



	public long getRentDueId() {
		return rentDueId;
	}

	public void setRentDueId(long rentDueId) {
		this.rentDueId = rentDueId;
	}

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public Landlord getLandlordId() {
		return getLandlordId();
	}

	public void setLandlordId(Landlord landlordId) {
		this.landlord= landlordId;
	}

	public Tenant getTenantId() {
		return tenantId;
	}

	public void setTenantId(Tenant tenantId) {
		this.tenantId = tenantId;
	}

	public Double getRentDueAmt() {
		return rentDueAmt;
	}

	public void setRentDueAmt(Double rentDueAmt) {
		this.rentDueAmt = rentDueAmt;
	}
}