package com.uninpahu.database.database.controller;

import com.uninpahu.database.database.entity.Careers;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IControllerCareer {

    ResponseEntity<List<Careers>> list();
}
