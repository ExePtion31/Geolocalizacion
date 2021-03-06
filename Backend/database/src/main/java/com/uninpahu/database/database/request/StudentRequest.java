package com.uninpahu.database.database.request;

public class StudentRequest {
    private String nombre;
    private String correo;
    private String password;
    private String jornada;
    private String carrera;
    private int role;

    public StudentRequest() {
    }

    public StudentRequest(String nombre, String correo, String password, String jornada, String carrera, int role) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.jornada = jornada;
        this.carrera = carrera;
        this.role = role;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
