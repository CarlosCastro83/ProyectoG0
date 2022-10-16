package com.usa.mtic.proyectog_0.service;

import com.usa.mtic.proyectog_0.models.Client;
import com.usa.mtic.proyectog_0.models.Reservation;
import com.usa.mtic.proyectog_0.models.dto.StatusAccount;
import com.usa.mtic.proyectog_0.models.dto.TopClients;
import com.usa.mtic.proyectog_0.repository.ReservationRepository;
import jdk.jshell.Snippet;
import net.bytebuddy.asm.MemberSubstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r){
        if (r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else {
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if (e.isPresent()){
                return r;
            }else {
                return reservationRepository.save(r);
            }
        }
    }

    public List<Reservation> getReservationsByPeriod(String dateA,String dateB){

        SimpleDateFormat parser=new SimpleDateFormat("yyy-MM-dd");
        Date a= new Date();
        Date b=new Date();
        try {
            a=parser.parse(dateA);
            b=parser.parse(dateB);
        }catch (ParseException e){
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.getDatesReport(a,b);
        }else {
            return new ArrayList<Reservation>();
        }
    }

    public StatusAccount getReportByStatus(){
        List<Reservation> completes=reservationRepository.getStatusReport("completed");
        List<Reservation> cancelled=reservationRepository.getStatusReport("cancelled");

        StatusAccount resultado=new StatusAccount(completes.size(),cancelled.size());
        return resultado;
    }

    public List<TopClients> getTopClients(){
        List<TopClients> tc=new ArrayList<>();
        List<Object[]> result= reservationRepository.getTopClients();

        for (int i=0;i<result.size();i++){
            int total=Integer.parseInt(result.get(i)[1].toString());
            Client client= (Client) result.get(i)[0];
            TopClients topClient=new TopClients(total,client);
            tc.add(topClient);
        }
        return tc;
    }


    public Reservation update(Reservation r){
        if (r.getIdReservation()!=null){
            Optional<Reservation> q =reservationRepository.getReservation(r.getIdReservation());
            if (q.isPresent()) {
                if (r.getStartDate()!=null){
                    q.get().setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(r.getDevolutionDate());
                }
                if (r.getStatus()!=null){
                    q.get().setStatus(r.getStatus());
                }
                reservationRepository.save(q.get());
                return q.get();
            }else {
                return r;
            }
        }else {
            return r;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>r=reservationRepository.getReservation(id);
        if (r.isPresent()){
            reservationRepository.delete(r.get());
            flag=true;
        }
        return flag;
    }
}
