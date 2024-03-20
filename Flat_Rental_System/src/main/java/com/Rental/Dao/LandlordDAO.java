package com.Rental.Dao;

import com.Rental.Entities.Landlord;
import com.Rental.Entities.Tenant;

import java.util.List;

public interface LandlordDAO {
    void addLandlord(Landlord landlord);
    Landlord getLandlordById(long id);
    List<Landlord> getAllLandlords();
    void updateLandlord(Landlord landlord);
    void deleteLandlord(long id);
    void printAllLandlords(List<Landlord> landlords);
	void addTenantToFlat(long flatId, Tenant tenant);
    
}
