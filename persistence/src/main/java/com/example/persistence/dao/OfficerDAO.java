package com.example.persistence.dao;

import com.example.persistence.entities.Officer;

import java.util.List;
import java.util.Optional;

public interface OfficerDAO {
//    Save
     Officer save(Officer officer);
//    find by ID
    Optional<Officer> findById(Integer id);
//    find all
    List<Officer> findAll();
//    count
    long count();
//    delete
    void delete(Officer officer);
//    exists by id
    boolean existsById(Integer id);
}
