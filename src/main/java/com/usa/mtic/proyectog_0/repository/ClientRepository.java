package com.usa.mtic.proyectog_0.repository;

import com.usa.mtic.proyectog_0.models.Client;
import com.usa.mtic.proyectog_0.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client l){
        return clientCrudRepository.save(l);
    }

    public void delete(Client l){
        clientCrudRepository.delete(l);
    }
}
