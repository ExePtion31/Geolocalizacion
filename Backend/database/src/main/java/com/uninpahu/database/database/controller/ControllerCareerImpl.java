package com.uninpahu.database.database.controller;

import com.uninpahu.database.database.entity.Careers;
import com.uninpahu.database.database.entity.User;
import com.uninpahu.database.database.request.*;
import com.uninpahu.database.database.service.CareerServiceImpl;
import com.uninpahu.database.database.service.ICareerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/career")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerCareerImpl implements IControllerCareer{

    @Autowired
    CareerServiceImpl service;

    @GetMapping("/list")
    @Override
    public ResponseEntity<List<Careers>> list() {
        try {
            List<Careers> careers = service.listAll();

            return new ResponseEntity<List<Careers>>(careers, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(new Message(err.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }


    @GetMapping("/list/{id}")
    @Override
    public ResponseEntity<Optional<Careers>> fetchUser(@PathVariable int id) {
        try {
            if(!service.existById(id)) {
                return new ResponseEntity(new Message("Carrera no encontrada"), HttpStatus.NOT_FOUND);
            }
            Optional<Careers> carrera = service.getOne(id);
            return new ResponseEntity<Optional<Careers>>(carrera, HttpStatus.OK);
        } catch(Exception err) {
            return new ResponseEntity(new Message(err.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<Message> create(@RequestBody CareersRequest careersRequest) {
        try {
            if (StringUtils.isBlank(careersRequest.getCarrera())) {
                return new ResponseEntity(new Message("La carrera es obligatoria"), HttpStatus.BAD_REQUEST);
            } else if (StringUtils.isBlank(careersRequest.getFacultad())) {
                return new ResponseEntity(new Message("La facultad es obligatoria"), HttpStatus.BAD_REQUEST);
            }

            Careers carrera = new Careers(careersRequest.getFacultad(), careersRequest.getCarrera());
            service.save(carrera);
            return new ResponseEntity(new Message("Carrera creada exitosamente"), HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(new Message(err.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<Message> update(@PathVariable int id, @RequestBody CareersRequest careersRequest) {
        try {
            if (StringUtils.isBlank(careersRequest.getCarrera())) {
                return new ResponseEntity(new Message("La carrera es obligatoria"), HttpStatus.BAD_REQUEST);
            } else if (StringUtils.isBlank(careersRequest.getFacultad())) {
                return new ResponseEntity(new Message("La facultad es obligatoria"), HttpStatus.BAD_REQUEST);
            }

            Careers carrera = service.getOne(id).get();
            carrera.setCarrera(careersRequest.getCarrera());
            carrera.setFacultad(careersRequest.getFacultad());
            service.save(carrera);
            return new ResponseEntity(new Message("Carrera actualizada exitosamente"), HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(new Message(err.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Message> delete(@PathVariable int id) {
        if (!service.existById(id)) {
            return new ResponseEntity(new Message("La ID proporcionada no existe."), HttpStatus.NOT_FOUND);
        }

        service.delete(id);
        return new ResponseEntity(new Message("Carrera eliminada exitosamente."), HttpStatus.OK);
    }
}
