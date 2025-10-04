package com.sunrise.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sunrise.pharmacy.service.CustomerService;

import main.java.com.sunrise.pharmacy.model.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public String listCustomers(Model model){
        List<Customer>customers = customerService.getAllCustomers();
         model.addAttribute("customers", customers);
        model.addAttribute("title", "Customer Management");
        return "customers/list";
    }

    @GetMapping("/register")
    public String registerCustomer(@ModelAttribute Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam String phone, Model model) {
        Customer customer = customerService.getCustomerByPhone(phone);
        model.addAttribute("customer", customer);
        model.addAttribute("phone", phone);
        model.addAttribute("title", "Search Customer");
        return "customers/search-result";
    }

    


}
