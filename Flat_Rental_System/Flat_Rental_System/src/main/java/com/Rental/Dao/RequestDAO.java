package com.Rental.Dao;
import com.Rental.Entities.Request;

public interface RequestDAO {
    Request findById(long id);
    void save(Request request);
    void update(Request request);
    void delete(Request request);
}
