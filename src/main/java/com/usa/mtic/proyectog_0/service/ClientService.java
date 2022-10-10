package com.usa.mtic.proyectog_0.service;

import com.usa.mtic.proyectog_0.models.Client;
import com.usa.mtic.proyectog_0.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client l){
        if (l.getIdClient()==null){
            return clientRepository.save(l);
        }else {
            Optional<Client> e = clientRepository.getClient(l.getIdClient());
            if (e.isPresent()){
                return l;
            }else {
                return clientRepository.save(l);
            }
        }
    }

    public Client update(Client l){
        if (l.getIdClient()!=null){
            Optional<Client> q =clientRepository.getClient(l.getIdClient());
            if (q.isPresent()){
                if (l.getName()!=null){
                    q.get().setName(l.getName());
                }
                if (l.getEmail()!=null){
                    q.get().setEmail(l.getEmail());
                }
                if (l.getPassword()!=null){
                    q.get().setPassword(l.getPassword());
                }
                if (l.getAge()!=null){
                    q.get().setAge(l.getAge());
                }
                if (l.getMessages()!=null){
                    q.get().setMessages(l.getMessages());
                }
                if (l.getReservations()!=null){
                    q.get().setReservations(l.getReservations());
                }
                clientRepository.save(q.get());
                return q.get();
            }else {
                return l;
            }
        }else {
            return l;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Client>l=clientRepository.getClient(id);
        if (l.isPresent()){
            clientRepository.delete(l.get());
            flag=true;
        }
        return flag;
    }
}
