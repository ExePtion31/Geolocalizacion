package com.uninpahu.database.database.request;

public class CareersRequest {
    private String carrera;
    private String facultad;

    public CareersRequest(String carrera, String facultad) {
        this.carrera = carrera;
        this.facultad = facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
}
