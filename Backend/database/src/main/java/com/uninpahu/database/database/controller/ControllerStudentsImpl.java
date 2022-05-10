package com.uninpahu.database.database.controller;

import com.uninpahu.database.database.entity.Student;
import com.uninpahu.database.database.request.*;
import com.uninpahu.database.database.service.StudentServiceImpl;
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
    StudentServiceImpl studentService;

    @Override
    @GetMapping("/list")
    public ResponseEntity<List<Student>> list() {
        List<Student> students = studentService.listAll();

        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @Override
    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Student>> fetchUser(@PathVariable int id) {
        if(!studentService.existById(id)) {
            return new ResponseEntity(new Message("El usuario no existe."), HttpStatus.NOT_FOUND);
        }
        Optional<Student> student = studentService.getOne(id);

        return new ResponseEntity<Optional<Student>>(student, HttpStatus.OK);
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<Message> create(@RequestBody StudentRequest studentRequest) {
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
        }

        Student student = new Student(studentRequest.getNombre(), studentRequest.getApellido(), studentRequest.getEdad(), studentRequest.getCorreo(), studentRequest.getTelefono());
        studentService.save(student);
        return new ResponseEntity(new Message("Usuario creado exitosamente"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Message> update(int id, StudentRequest studentRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Message> delete(int id) {
        return null;
    }
}
