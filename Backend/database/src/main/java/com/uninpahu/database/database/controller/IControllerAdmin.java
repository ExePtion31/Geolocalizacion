package com.uninpahu.database.database.controller;

import com.uninpahu.database.database.entity.Student;
import com.uninpahu.database.database.request.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public interface IControllerAdmin {

    ResponseEntity<List<Student>> list();

    ResponseEntity<Optional<Student>> fetchUser(int id);

    ResponseEntity<Message> create(StudentRequest studentRequest);

    ResponseEntity<Message> update(int id, StudentRequest studentRequest);

    ResponseEntity<Message> delete(int id);
}
