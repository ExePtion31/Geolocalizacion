package com.uninpahu.database.database.controller;

import com.uninpahu.database.database.entity.Careers;
import com.uninpahu.database.database.request.Message;
import com.uninpahu.database.database.service.ICareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/career")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerCareerImpl implements IControllerCareer{

    @Autowired
    ICareerService service;

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
}
