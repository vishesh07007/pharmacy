package com.sunrise.pharmacy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunrise.pharmacy.model.Medicine;
import com.sunrise.pharmacy.repository.MedicineRepository;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public List<Medicine> getallMedicines(){
        return medicineRepository.findAll();
    }

    public Medicine getMedicineByid(Long id){
        Optional<Medicine> medicine = medicineRepository.findById(id);
        return medicine.orElse(null);
    }

    public Medicine saveMedicine(Medicine medicine){
        return medicineRepository.save(medicine);
    }

    public void deleteMedicine(Long id){
        medicineRepository.deleteById(id);
    }

    public List<Medicine> getMedicinesByCategory(String category) {
        return medicineRepository.findByCategory(category);
    }

    public List<Medicine> getLowStockMedicines() {
        return medicineRepository.findByStockQuantityLessThan(10);
    }

    public Medicine updateStock(Long medicineId,Integer newQuantity){
        Medicine medicine = getMedicineByid(medicineId);
        if(medicine !=null){
            medicine.setStockQuantity(newQuantity);
            return medicineRepository.save(medicine);
        }
        return null;
        }
    

}
