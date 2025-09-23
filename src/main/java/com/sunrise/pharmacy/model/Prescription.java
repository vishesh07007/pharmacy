package com.sunrise.pharmacy.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;


@Entity
@Table(name = "prescriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name",nullable=false)
    private String customerName;

     @Column(name = "customer_phone", nullable = false)
    private String customerPhone;
    
    @Column(name = "prescription_image_path")
    private String prescriptionImagePath;
    
    @Column(name = "preferred_pickup_time", nullable = false)
    private LocalDateTime preferredPickupTime;
    
    @Column(name = "status")
    private String status = "PENDING";
    
    @Column(name = "notes", length = 1000)
    private String notes;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    // Constructor without ID
    public Prescription(String customerName, String customerPhone, 
                       String prescriptionImagePath, 
                       LocalDateTime preferredPickupTime, String notes) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.prescriptionImagePath = prescriptionImagePath;
        this.preferredPickupTime = preferredPickupTime;
        this.notes = notes;



     }
     
}
