package com.uninpahu.database.database.controller;

import java.util.*;
import com.uninpahu.database.database.entity.Student;
import com.uninpahu.database.database.request.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

public interface IControllerStudents {

    ResponseEntity<Optional<Student>> fetchUser(loginRequest user);

    ResponseEntity<Message> create(StudentRequest studentRequest);
}
