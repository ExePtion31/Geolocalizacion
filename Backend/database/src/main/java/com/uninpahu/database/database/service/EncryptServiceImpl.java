package com.uninpahu.database.database.service;

import com.uninpahu.database.database.repository.IRepositoryStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class EncryptServiceImpl implements IEncryptService{
    @Autowired
    private IRepositoryStudents repository;

    @Override
    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean verifyPassword(String originalPassword, String hashPassword) {
        return BCrypt.checkpw(originalPassword, hashPassword);
    }
}
