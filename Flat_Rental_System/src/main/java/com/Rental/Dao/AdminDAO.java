package com.Rental.Dao;





import com.Rental.Entities.Admin;

public interface AdminDAO {
    Admin findById(long id);
    void saveAdmin(Admin admin);
    void update(Admin admin);
    void delete(Admin admin);
   
}
