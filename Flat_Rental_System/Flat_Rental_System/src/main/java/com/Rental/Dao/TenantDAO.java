package com.Rental.Dao;

import com.Rental.Entities.Tenant;

public interface TenantDAO {
    Tenant findById(long id);
    void save(Tenant tenant);
    void update(Tenant tenant);
    void delete(Tenant tenant);
}
