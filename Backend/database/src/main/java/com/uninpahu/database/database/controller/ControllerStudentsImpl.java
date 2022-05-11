package com.uninpahu.database.database.controller;

import com.uninpahu.database.database.entity.Student;
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
public class ControllerStudentsImpl implements IControllerStudents{
    @Autowired
    CommonServiceImpl commonService;

    @Autowired
    EncryptServiceImpl encryptService;

    @PostMapping("/validation/login")
    @Override
    public ResponseEntity<Optional<Student>> fetchUser(@RequestBody loginRequest loginRequest) {
        try {
            if(!commonService.existByCorreo(loginRequest.getCorreo())) {
                return new ResponseEntity(new Message("El usuario no esta registrado"), HttpStatus.NOT_FOUND);
            }

            Optional<Student> student = commonService.getByCorreo(loginRequest.getCorreo());
            if(!encryptService.verifyPassword(loginRequest.getPassword(), student.get().getPassword())) {
                return new ResponseEntity(new Message("Correo o contraseña incorrectas"), HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<Optional<Student>>(student, HttpStatus.OK);
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
            } else if (StringUtils.isBlank(studentRequest.getApellido())) {
                return new ResponseEntity(new Message("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
            } else if (StringUtils.isBlank(studentRequest.getCorreo())) {
                return new ResponseEntity(new Message("El correo es obligatorio"), HttpStatus.BAD_REQUEST);
            } else if (studentRequest.getEdad() < 0) {
                return new ResponseEntity(new Message("Ingrese una edad válida"), HttpStatus.BAD_REQUEST);
            } else if (studentRequest.getTelefono() < 0) {
                return new ResponseEntity(new Message("Ingrese un teléfono válida"), HttpStatus.BAD_REQUEST);
            } else if (StringUtils.isBlank(studentRequest.getPassword())) {
                return new ResponseEntity(new Message("La contraseña es obligatoria"), HttpStatus.BAD_REQUEST);
            }

            Student student = new Student(studentRequest.getNombre(), studentRequest.getApellido(), studentRequest.getEdad(), studentRequest.getCorreo(), studentRequest.getTelefono(), encryptService.encryptPassword(studentRequest.getPassword()));
            commonService.save(student);
            return new ResponseEntity(new Message("Usuario creado exitosamente"), HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(new Message(err.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }
}
