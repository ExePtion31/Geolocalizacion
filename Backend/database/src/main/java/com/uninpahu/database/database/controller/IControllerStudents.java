package com.uninpahu.database.database.controller;

import java.util.*;
import com.uninpahu.database.database.entity.User;
import com.uninpahu.database.database.request.*;
import org.springframework.http.*;

public interface IControllerStudents {

    ResponseEntity<LoginResponse> fetchUser(loginRequest user);

    ResponseEntity<Message> create(StudentRequest studentRequest);
}
