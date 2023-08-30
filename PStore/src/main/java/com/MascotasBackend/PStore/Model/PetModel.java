package com.MascotasBackend.PStore.Model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
@Entity
@Table(name="perros")




public class PetModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)


    @Column

    private Integer Id;

    @Column
    private String Nombre;

    @Column
    private String Acudiente;




    @Column
    private String Raza;

    @Column
    private String Path_F;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getAcudiente() {
        return Acudiente;
    }

    public void setAcudiente(String acudiente) {
        Acudiente = acudiente;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        Raza = raza;
    }

    public String getPath_F() {
        return Path_F;
    }

    public void setPath_F(String path_F) {
        Path_F = path_F;
    }
}
