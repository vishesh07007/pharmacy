package com.sunrise.pharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunrise.pharmacy.model.Customer;
import com.sunrise.pharmacy.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerByPhone(String phone) {
        Optional<Customer> customer = customerRepository.findByPhone(phone);
        return customer.orElse(null);
    }

     public boolean customerExists(String phone) {
        return customerRepository.existsByPhone(phone);
    }

    public Customer registerCustomer(String name, String phone, String email, String address) {
        
        Customer existingCustomer = getCustomerByPhone(phone);
        if (existingCustomer != null) {
            return existingCustomer;
        }
        
        Customer newCustomer = new Customer(name, phone, email, address);
        return customerRepository.save(newCustomer);
    }



}
