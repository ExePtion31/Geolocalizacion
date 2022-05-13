package com.uninpahu.database.database.service;

import com.uninpahu.database.database.entity.User;

import java.util.Optional;

public interface ICommonService {


    boolean existByCorreo(String correo);

    Optional<User> getByCorreo(String correo);

    User save(User user);

}
