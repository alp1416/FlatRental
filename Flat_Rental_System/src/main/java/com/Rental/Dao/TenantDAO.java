package com.Rental.Dao;

import java.util.List;

import com.Rental.Entities.Tenant;

public interface TenantDAO {
    Tenant findById(long id);
    void save(Tenant tenant);
    void update(Tenant tenant);
    void delete(Tenant tenant);
    List<Tenant> getAllTenants();
    void printAllTenants(List<Tenant> tenants);
	List<Tenant> getTenantsByLandlordId(long landlordId);
}
