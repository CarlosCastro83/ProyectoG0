package com.usa.mtic.proyectog_0.controller;

import com.usa.mtic.proyectog_0.models.Category;
import com.usa.mtic.proyectog_0.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/save")
    public Category save(@RequestBody Category a){
        return categoryService.save(a);
    }
}
