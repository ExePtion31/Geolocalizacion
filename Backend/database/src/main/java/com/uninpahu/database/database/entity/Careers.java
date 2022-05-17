package com.uninpahu.database.database.entity;
import javax.persistence.*;

@Entity
public class Careers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String facultad;
    @Column
    private String carrera;

    public Careers() {
    }

    public Careers(String facultad, String carrera) {
        this.facultad = facultad;
        this.carrera = carrera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
