package com.uninpahu.database.database.service;

import com.uninpahu.database.database.entity.User;
import com.uninpahu.database.database.repository.IRepositoryStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CommonServiceImpl implements ICommonService {
    @Autowired
    IRepositoryStudents repository;

    @Override
    public boolean existByCorreo(String correo) {
        return repository.existsByCorreo(correo);
    }

    @Override
    public Optional<User> getByCorreo(String correo) {
        return repository.getByCorreo(correo);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
