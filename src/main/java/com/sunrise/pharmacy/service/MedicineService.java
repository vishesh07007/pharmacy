package com.sunrise.pharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public List<Medicine> getallMedicines(){
        return medicineRepository.findAll();
    }

    public Medicine get
}
