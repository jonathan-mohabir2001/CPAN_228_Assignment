package com.cpan228.warehouse.controller;

import com.cpan228.warehouse.model.Clothing;
import com.cpan228.warehouse.repository.ClothingRepository;

import lombok.Builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clothes")
public class ClothesController {

  @Autowired
  private ClothingRepository clothingRepository;

  @GetMapping
  public String showAddForm(Model model) {
    model.addAttribute("clothing", Clothing.builder().build());
    return "addClothing";
  }

  @PostMapping("/add")
  public String addClothing(@ModelAttribute("clothing") Clothing clothing) {
    clothingRepository.save(clothing);
    return "redirect:/clothes/list";
  }

  @GetMapping("/list")
  public String showClothingList(Model model) {
    List<Clothing> clothingList = clothingRepository.findAll();
    model.addAttribute("clothingList", clothingList);
    return "listOfClothing";
  }

}
