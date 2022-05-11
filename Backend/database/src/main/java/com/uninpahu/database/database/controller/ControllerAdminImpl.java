package com.uninpahu.database.database.controller;

import com.uninpahu.database.database.entity.Student;
import com.uninpahu.database.database.request.*;
import com.uninpahu.database.database.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/admin")
public class ControllerAdminImpl implements IControllerAdmin{
    @Autowired
    AdminServiceImpl adminService;

    @Autowired
    CommonServiceImpl commonService;

    @Autowired
    EncryptServiceImpl encryptService;

    @GetMapping("/list")
    @Override
    public ResponseEntity<List<Student>> list() {
        try {
            List<Student> students = adminService.listAll();

            return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(new Message(err.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/list/{id}")
    @Override
    public ResponseEntity<Optional<Student>> fetchUser(@PathVariable int id) {
        try {
            if(!adminService.existById(id)) {
                return new ResponseEntity(new Message("Usuario no encontrado"), HttpStatus.NOT_FOUND);
            }
            Optional<Student> student = adminService.getOne(id);
            return new ResponseEntity<Optional<Student>>(student, HttpStatus.OK);
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

    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<Message> update(@PathVariable int id, @RequestBody StudentRequest studentRequest) {
        try {
            if (StringUtils.isBlank(studentRequest.getNombre())) {
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

            Student student = adminService.getOne(id).get();
            student.setNombre(studentRequest.getNombre());
            student.setApellido(studentRequest.getApellido());
            student.setEdad(studentRequest.getEdad());
            student.setCorreo(studentRequest.getCorreo());
            student.setTelefono(studentRequest.getTelefono());
            student.setPassword(encryptService.encryptPassword(studentRequest.getPassword()));
            commonService.save(student);
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
        return new ResponseEntity(new Message("Usuario eliminado exitosamente."), HttpStatus.NOT_FOUND);
    }
}
