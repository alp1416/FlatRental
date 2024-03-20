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
@Table(name = "Request")
public class Request {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    @Column(name = "Request_Id")
    private long requestId;
    
    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "Flat_Id")
    private Flat flatId;
    
    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "Landlord_Id")
    private Landlord landlord;
    
    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "Tenant_Id")
    private Tenant tenantId;

	public Request(long requestId, Flat flatId, Landlord landlord, Tenant tenantId) {
		super();
		this.requestId = requestId;
		this.flatId = flatId;
		this.landlord = landlord;
		this.tenantId = tenantId;
	}

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	   @Override
	    public String toString() {
	        return "Request{" +
	                "requestId=" + requestId +
	                ", flatId=" + (flatId != null ? flatId.getFlatId() : "null") +
	                ", landlord=" + (landlord != null ? landlord.getLandlordId() : "null") +
	                ", tenantId=" + (tenantId != null ? tenantId.getTenantId() : "null") +
	                '}';
	    }

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public Flat getFlatId() {
		return flatId;
	}

	public void setFlatId(Flat flatId) {
		this.flatId = flatId;
	}

	public Landlord getLandlord() {
		return landlord;
	}

	public void setLandlordId(Landlord landlord) {
		this.landlord = landlord;
	}

	public Tenant getTenantId() {
		return tenantId;
	}

	public void setTenantId(Tenant tenantId) {
		this.tenantId = tenantId;
	}
	
}

   