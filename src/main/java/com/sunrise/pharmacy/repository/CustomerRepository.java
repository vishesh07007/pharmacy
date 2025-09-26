package com.sunrise.pharmacy.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sunrise.pharmacy.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Optional<Customer> findByPhone(String phone);

    Optional<Customer> findByNameContainingIgnoreCase(String name);

    boolean existsByPhone(String phone);

    Optional<Customer> findByEmail(String email);


}
