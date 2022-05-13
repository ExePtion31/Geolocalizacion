package com.uninpahu.database.database.controller;

import com.uninpahu.database.database.entity.User;
import com.uninpahu.database.database.request.*;
import com.uninpahu.database.database.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerStudentsImpl implements IControllerStudents{
    @Autowired
    CommonServiceImpl commonService;

    @Autowired
    EncryptServiceImpl encryptService;

    @PostMapping("/validation/login")
    @Override
    public ResponseEntity<LoginResponse> fetchUser(@RequestBody loginRequest loginRequest) {
        try {
            if(!commonService.existByCorreo(loginRequest.getCorreo())) {
                return new ResponseEntity(new Message("El usuario no esta registrado"), HttpStatus.NOT_FOUND);
            }

            Optional<User> student = commonService.getByCorreo(loginRequest.getCorreo());
            if(!encryptService.verifyPassword(loginRequest.getPassword(), student.get().getPassword())) {
                return new ResponseEntity(new Message("Correo o contraseña incorrectas"), HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<LoginResponse>(new LoginResponse(student.get().getId(), student.get().getRole() ,"Login Exitoso"), HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(new Message(err.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<Message> create(@RequestBody StudentRequest studentRequest) {
        try {
            if(commonService.existByCorreo(studentRequest.getCorreo())) {
                return new ResponseEntity(new Message("Este correo ya se encuentra registrado"), HttpStatus.BAD_REQUEST);
            }else if (StringUtils.isBlank(studentRequest.getNombre())) {
                return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            } else if (studentRequest.getRole() < 0 && studentRequest.getRole() > 1) {
                return new ResponseEntity(new Message("El rol no existe"), HttpStatus.BAD_REQUEST);
            } else if (StringUtils.isBlank(studentRequest.getCorreo())) {
                return new ResponseEntity(new Message("El correo es obligatorio"), HttpStatus.BAD_REQUEST);
            } else if (StringUtils.isBlank(studentRequest.getJornada())) {
                return new ResponseEntity(new Message("Ingrese una jornada"), HttpStatus.BAD_REQUEST);
            } else if (StringUtils.isBlank(studentRequest.getCarrera())) {
                return new ResponseEntity(new Message("Ingrese una carrera"), HttpStatus.BAD_REQUEST);
            } if (StringUtils.isBlank(studentRequest.getPassword())) {
                return new ResponseEntity(new Message("La contraseña es obligatoria"), HttpStatus.BAD_REQUEST);
            }

            User user = new User(studentRequest.getNombre(), studentRequest.getCorreo(), encryptService.encryptPassword(studentRequest.getPassword()), studentRequest.getJornada(), studentRequest.getCarrera(), studentRequest.getRole());
            commonService.save(user);
            return new ResponseEntity(new Message("Usuario creado exitosamente"), HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(new Message(err.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }
}
