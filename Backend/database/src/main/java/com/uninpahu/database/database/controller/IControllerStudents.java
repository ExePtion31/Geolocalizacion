package com.uninpahu.database.database.controller;

import java.util.*;
import com.uninpahu.database.database.entity.Student;
import com.uninpahu.database.database.request.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

public interface IControllerStudents {

    ResponseEntity<List<Student>> list();

    ResponseEntity<Optional<Student>> fetchUser(int id);

    ResponseEntity<Message> create(@RequestBody StudentRequest studentRequest);

    ResponseEntity<Message> update(@PathVariable("id") int id, @RequestBody StudentRequest studentRequest);

    ResponseEntity<Message> delete(@PathVariable("id") int id);
}
