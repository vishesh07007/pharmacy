package com.sunrise.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sunrise.pharmacy.model.Prescription;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    
   
    List<Prescription> findByStatus(String status);
    
    
    List<Prescription> findByCustomerPhone(String customerPhone);
    
  
    List<Prescription> findByPreferredPickupTimeBetween(
        LocalDateTime startDate, 
        LocalDateTime endDate
    );
    
    
    List<Prescription> findByStatusOrderByPreferredPickupTimeAsc(String status);
}