package com.usa.mtic.proyectog_0.service;

import com.usa.mtic.proyectog_0.models.Computer;
import com.usa.mtic.proyectog_0.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> getAll(){
        return computerRepository.getAll();
    }

    public Optional<Computer> getComputer(int id){
        return computerRepository.getComputer(id);
    }

    public Computer save(Computer c){
        if (c.getId()==null){
            return computerRepository.save(c);
        }else {
            Optional<Computer> e = computerRepository.getComputer(c.getId());
            if (e.isPresent()){
                return c;
            }else {
                return computerRepository.save(c);
            }
        }
    }

    public Computer update(Computer c){
        if(c.getId()!=null){
            Optional<Computer> q =computerRepository.getComputer(c.getId());
            if (q.isPresent()){
                if (c.getName()!=null){
                    q.get().setName(c.getName());
                }
                if (c.getBrand()!=null){
                    q.get().setBrand(c.getBrand());
                }
                if (c.getYear()!=null){
                    q.get().setYear(c.getYear());
                }
                if (c.getDescription()!=null){
                    q.get().setDescription(c.getDescription());
                }
                if (c.getCategory()!=null){
                    q.get().setCategory(c.getCategory());
                }
                computerRepository.save(q.get());
                return q.get();
            }else {
                return c;
            }
        } else {
            return c;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Computer>c=computerRepository.getComputer(id);
        if (c.isPresent()){
            computerRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
