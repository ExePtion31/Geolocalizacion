package com.uninpahu.database.database.controller;

import com.uninpahu.database.database.entity.User;
import com.uninpahu.database.database.request.*;
import com.uninpahu.database.database.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerAdminImpl implements IControllerAdmin{
    @Autowired
    AdminServiceImpl adminService;

    @Autowired
    CommonServiceImpl commonService;

    @Autowired
    EncryptServiceImpl encryptService;

    @GetMapping("/list")
    @Override
    public ResponseEntity<List<User>> list() {
        try {
            List<User> users = adminService.listAll();

            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(new Message(err.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/list/{id}")
    @Override
    public ResponseEntity<Optional<User>> fetchUser(@PathVariable int id) {
        try {
            if(!adminService.existById(id)) {
                return new ResponseEntity(new Message("Usuario no encontrado"), HttpStatus.NOT_FOUND);
            }
            Optional<User> student = adminService.getOne(id);
            return new ResponseEntity<Optional<User>>(student, HttpStatus.OK);
        } catch(Exception err) {
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

    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<Message> update(@PathVariable int id, @RequestBody StudentRequest studentRequest) {
        try {
            if (StringUtils.isBlank(studentRequest.getNombre())) {
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

            User user = adminService.getOne(id).get();
            user.setNombre(studentRequest.getNombre());
            user.setCorreo(studentRequest.getCorreo());
            user.setPassword(encryptService.encryptPassword(studentRequest.getPassword()));
            user.setJornada(studentRequest.getJornada());
            user.setCarrera(studentRequest.getCarrera());
            user.setRole(studentRequest.getRole());
            commonService.save(user);
            return new ResponseEntity(new Message("Usuario actualizado exitosamente"), HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(new Message(err.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Message> delete(@PathVariable int id) {
        if (!adminService.existById(id)) {
            return new ResponseEntity(new Message("La ID proporcionada no existe."), HttpStatus.NOT_FOUND);
        }

        //delete of developer
        adminService.delete(id);
        return new ResponseEntity(new Message("Usuario eliminado exitosamente."), HttpStatus.OK);
    }
}
