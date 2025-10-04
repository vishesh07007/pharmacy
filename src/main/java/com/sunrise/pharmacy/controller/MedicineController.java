package com.sunrise.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunrise.pharmacy.model.Medicine;
import com.sunrise.pharmacy.service.MedicineService;

@Controller
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public String listMedicines(Model model){
        List<Medicine> medicines = medicineService.getallMedicines();
        model.addAttribute("medicines",medicines);
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
    public String addMedicine(@ModelAttribute Medicine medicine){
        medicineService.saveMedicine(medicine);
        return "redirect:/medicines";
    }

    @GetMapping("/edit/{id}")
    public String showEditMedicineForm(@PathVariable Long id,Model model){
        Medicine medicine = medicineService.getMedicineByid(id);
        model.addAttribute("medicine", medicine);
        model.addAttribute("title", "Edit Medicine");
        return "medicines/edit";

    }

    @PostMapping("/edit/{id}")
    public String updateMedicine(@PathVariable Long id, @ModelAttribute Medicine medicine) {
        medicine.setId(id);
        medicineService.saveMedicine(medicine);
        return "redirect:/medicines";
    }

    @GetMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return "redirect:/medicines";
    }

    @GetMapping("/search")
    public String searchMedicines(@RequestParam String keyword, Model model) {
        List<Medicine> medicines = medicineService.searchMedicines(keyword);
        model.addAttribute("medicines", medicines);
        model.addAttribute("keyword", keyword);
        model.addAttribute("title", "Search Results");
        return "medicines/list";
    }

    @GetMapping("/low-stock")
    public String showLowStockMedicines(Model model) {
        List<Medicine> lowStockMedicines = medicineService.getLowStockMedicines();
        model.addAttribute("medicines", lowStockMedicines);
        model.addAttribute("title", "Low Stock Medicines");
        return "medicines/low-stock";
    }



}
