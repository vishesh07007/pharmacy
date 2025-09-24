package com.sunrise.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sunrise.pharmacy.model.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    List<Medicine> findByNameContainingIgnoreCase(String name);

    List<Medicine> findByCategory(String category);
    
    List<Medicine> findByStockQuantityLessThan(Integer quantity);
    
    List<Medicine> findByManufacturerContainingIgnoreCase(String manufacturer);

}
