package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.enumeration.Role;

import java.util.Optional;

public interface UserService {
     User register(String username, String password, String repeatPassword, String name, String surname, Role role);
     User login(String username, String password);

}
