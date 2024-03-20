package com.Rental.Dao;



import com.Rental.Entities.Admin;

public interface AdminDAO {
    Admin findById(long id);
    void save(Admin admin);
    void update(Admin admin);
    void delete(Admin admin);
}
