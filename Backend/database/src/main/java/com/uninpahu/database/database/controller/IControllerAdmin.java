package com.uninpahu.database.database.controller;

import com.uninpahu.database.database.entity.User;
import com.uninpahu.database.database.request.*;
import org.springframework.http.ResponseEntity;

import java.util.*;

public interface IControllerAdmin {

    ResponseEntity<List<User>> list();

    ResponseEntity<Optional<User>> fetchUser(int id);

    ResponseEntity<Message> create(StudentRequest studentRequest);

    ResponseEntity<Message> update(int id, StudentRequest studentRequest);

    ResponseEntity<Message> delete(int id);
}
