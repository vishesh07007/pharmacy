package com.sunrise.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.sunrise.pharmacy.model.Medicine;
import com.sunrise.pharmacy.service.MedicineService;
import java.util.List;

@Controller
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public String listMedicines(Model.model){
        List<Medicine> medicine = medicineService.getallMedicines();
        model.addAttribute("medicined",medicines);
        model.addAttribute("title","Medicine Inventory");
        return "medicines/List";

    }

    @GetMapping("/add")
    public String showMedicineForm(Model model){
            model.addAttribute("medicine", new Medicine());
            model.addAttribute("title", "Add New Medicine");
            return "medicines/add";
    }

    @PostMapping("/add")
    public String addMedicine(@ModelAttribute Medicine medicine)
        medicineService.saveMedicine(medicine);
        return "redirect:/medicines";
    }

    



    


    
    

}
