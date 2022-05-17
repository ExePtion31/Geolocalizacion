package com.uninpahu.database.database.controller;

import com.uninpahu.database.database.entity.Careers;
import com.uninpahu.database.database.request.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IControllerCareer {

    ResponseEntity<List<Careers>> list();

    ResponseEntity<Optional<Careers>> fetchUser(int id);

    ResponseEntity<Message> create(CareersRequest careersRequest);

    ResponseEntity<Message> update(int id, CareersRequest careersRequest);

    ResponseEntity<Message> delete(int id);
}
