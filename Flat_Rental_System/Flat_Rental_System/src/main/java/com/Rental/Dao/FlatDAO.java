package com.Rental.Dao;

import com.Rental.Entities.Flat;

import java.util.List;

public interface FlatDAO {
    // Create operation
    void addFlat(Flat flat);

    // Read operation
    Flat getFlatById(long id);
    List<Flat> getAllFlats();

    // Update operation
    void updateFlat(Flat flat);

    // Delete operation
    void deleteFlat(long id);
}
