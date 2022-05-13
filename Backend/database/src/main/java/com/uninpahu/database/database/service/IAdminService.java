package com.uninpahu.database.database.service;

import com.uninpahu.database.database.entity.User;

import java.util.List;
import java.util.Optional;

public interface IAdminService {

    boolean existById(int id);

    Optional<User> getOne(int id);

    List<User> listAll();

    void delete(int id);
}
