package com.uninpahu.database.database.service;

import com.uninpahu.database.database.entity.Careers;
import com.uninpahu.database.database.entity.User;

import java.util.List;
import java.util.Optional;

public interface ICareerService {

    List<Careers> listAll();

    boolean existById(int id);

    Optional<Careers> getOne(int id);

    Careers save(Careers carrera);

    void delete(int id);
}
