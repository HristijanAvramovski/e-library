package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.model.enumeration.Role;
import com.example.demo.model.exceptions.InvalidUsernameOrPasswordException;
import com.example.demo.model.exceptions.PasswordsDoNotMatchException;
import com.example.demo.repository.jpa.UserRepository;
import com.example.demo.service.UserService;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidUsernameOrPasswordException();
        }
        if(!password.equals(repeatPassword)){
            throw new PasswordsDoNotMatchException();
        }
        User user=new User(username, password, name, surname, role);
        userRepository.save(user);
        return user;
    }

    @Override
    public User login(String username, String password) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidUsernameOrPasswordException();
        }
        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUsernameOrPasswordException::new);
    }

}
