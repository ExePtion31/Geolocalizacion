package com.uninpahu.database.database.service;

public interface IEncryptService {

    String encryptPassword(String password);

    boolean verifyPassword(String originasPassword, String hashPassword);
}
