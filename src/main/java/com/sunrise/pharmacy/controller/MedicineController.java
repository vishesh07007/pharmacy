package com.sunrise.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private medicineController;

    @GetMapping
    public String ListMedicine
    

}
