package com.MascotasBackend.PStore.Controller;
import com.MascotasBackend.PStore.services.PetService;
import com.MascotasBackend.PStore.services.Imp.uploadFilesSeviceImp;
import com.MascotasBackend.PStore.Model.PetModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import org.json.*;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@RestController
@RequestMapping("/Pet")

public class PetController {


    @Autowired
    private PetService mascotaServices;
    uploadFilesSeviceImp  Uploadsevice;
    private ArrayList Devuelto;

    @PostMapping("/upload")

    private ResponseEntity<String> uploadPic(MultipartFile file) throws Exception {
       return new ResponseEntity<>(Uploadsevice.managerFileUpload(MultipartFile file));

    }





    public void debeDevolverJSONEnUnProperties() {
        final String json = "{\"id\":46,\"nombre\":\"Miguel\",\"empresa\":\"Autentia\"}";
        final Gson gson = new Gson();
        final Properties properties = gson.fromJson(json, Properties.class);
        assertEquals("46", properties.getProperty("id"));
        assertEquals("Miguel", properties.getProperty("nombre"));
        assertEquals("Autentia", properties.getProperty("empresa"));
        assertNull(properties.getProperty("propiedadInexistente"));
        System.out.println(properties);
    }



    @GetMapping

    public   String getMascotas(){


        this.Devuelto= this.mascotaServices.getMascotas();

        Gson gson = new Gson();
        String jsonArray = gson.toJson(this.Devuelto);


        return jsonArray;

        
    }

    @PostMapping

    public PetModel saveMascota(@RequestBody PetModel mascotas){


        return this.mascotaServices.saveMascota(mascotas);
    }

    @GetMapping(path= "/{id}")
    public Optional<PetModel> getMascotaById(@PathVariable("id") Long id){
        return this.mascotaServices.getPet(id);


    }

    @PutMapping


    public PetModel ActualizarMascotaById(@RequestBody PetModel request){
        return this.mascotaServices.upDateById(request);


    }



    @DeleteMapping(path = "/{id}")

    public String deleteMascotaById(@PathVariable("id") Long id){

        final String json = "{\"id\":46,\"resultado\":\"OK\",\"mensaje\":\"Registro eliminado satisfactoriamente\"}";


       boolean ok= mascotaServices.deleteMascota(id);




       if(ok){

           return  json;

       }else{

           return " try  Failed, We have a error with de execution";

       }




}


    public boolean procesaFicheros(HttpServletRequest req) {
        try {
            DiskFileUpload fu = new DiskFileUpload();// construimos el objeto que es capaz de parsear la pericion
            fu.setSizeMax(1024*512); // máximo numero de bytes (512)
            fu.setSizeThreshold(4096);// tamaño por encima del cual los ficheros son escritos directamente en disco
            fu.setRepositoryPath("/tmp");// directorio en el que se escribirán los ficheros con tamaño superior al soportado en memoria
            List fileItems = fu.parseRequest(req);// ordenamos procesar los ficheros
            if(fileItems == null) {
                System.out.println("La lista es nula");
                return false;
            }
            Iterator i = fileItems.iterator();// Iteramos por cada fichero
            FileItem actual = null;
            while (i.hasNext()){
                actual = (FileItem)i.next();
                String fileName = actual.getName();
                File fichero = new File(fileName);// construimos un objeto file para recuperar el trayecto completo
                System.out.println("El nombre del fichero es " + fichero.getName());// nos quedamos solo con el nombre y descartamos el path
                fichero = new  File("/home/monty/Desktop/"+fichero.getName());// escribimos el fichero colgando del nuevo path
                actual.write(fichero);
            }
        }catch(Exception e) {
            System.out.println("Error de Aplicación " + e.getMessage());
            return false;
        }
        return true;
    }






}
