package com.MascotasBackend.PStore.services;
import com.MascotasBackend.PStore.Model.PetModel;
import  com.MascotasBackend.PStore.Repositories.PetInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class PetService {
    @Autowired

    PetInterface PetInterface;

    public ArrayList<PetModel> getMascotas(){

        return (ArrayList<PetModel>) PetInterface.findAll();
    }

   public PetModel saveMascota(PetModel Mascota){

        return PetInterface.save(Mascota);


   }

   public Optional<PetModel> getPet(Long id){


       return PetInterface.findById(id);
   }

   public PetModel upDateById(PetModel Mascota){

       return PetInterface.save(Mascota);

   }

   public Boolean deleteMascota(Long id){

       try
       {
           PetInterface.deleteById(id);
           return true;
       }
       catch(Exception e){

           return false;


       }

   }

}
