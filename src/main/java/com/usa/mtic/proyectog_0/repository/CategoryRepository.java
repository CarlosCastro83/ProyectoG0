package com.usa.mtic.proyectog_0.repository;

import com.usa.mtic.proyectog_0.models.Category;
import com.usa.mtic.proyectog_0.repository.crudRepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category a){
        return categoryCrudRepository.save(a);
    }

    public void delete(Category a){
        categoryCrudRepository.delete(a);
    }

}
