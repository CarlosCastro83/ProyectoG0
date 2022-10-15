package com.usa.mtic.proyectog_0.service;

import com.usa.mtic.proyectog_0.models.Category;
import com.usa.mtic.proyectog_0.models.Computer;
import com.usa.mtic.proyectog_0.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Category save(Category a){
        if (a.getId()==null){
            return categoryRepository.save(a);
        }else {
            Optional<Category> e = categoryRepository.getCategory(a.getId());
            if (e.isEmpty()){
                return categoryRepository.save(a);
            }else {
                return a;
            }
        }
    }

    public Category update(Category a){
        if (a.getId()!=null){
            Optional<Category> q =categoryRepository.getCategory(a.getId());
            if (q.isPresent()){
                if (a.getName()!=null){
                    q.get().setName(a.getName());
                }
                if (a.getDescription()!=null){
                    q.get().setDescription(a.getDescription());
                }
                categoryRepository.save(q.get());
                return q.get();
            }else {
                return a;
            }
        }else {
            return a;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Category>a=categoryRepository.getCategory(id);
        if (a.isPresent()){
            categoryRepository.delete(a.get());
            flag=true;
        }
        return flag;
    }
}
