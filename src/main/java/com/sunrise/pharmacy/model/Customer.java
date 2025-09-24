package com.sunrise.pharmacy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

     @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "address")
    private String address;

    public Customer(String name, String phone, String email, String address){
        this.name=name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }



}
