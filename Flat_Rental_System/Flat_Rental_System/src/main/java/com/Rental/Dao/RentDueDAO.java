package com.Rental.Dao;
import com.Rental.Entities.RentDue;

public interface RentDueDAO {
    RentDue findById(long id);
    void save(RentDue rentDue);
    void update(RentDue rentDue);
    void delete(RentDue rentDue);
}
