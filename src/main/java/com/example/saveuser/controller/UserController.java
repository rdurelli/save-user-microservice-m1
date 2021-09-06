package com.example.saveuser.controller;

import com.example.saveuser.model.DAO.UserDAO;
import com.example.saveuser.model.User;
import com.example.saveuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.Beans;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User saveUser(@RequestBody @Valid UserDAO userDAO) {
        User userToSave = User.builder().build();
        BeanUtils.copyProperties(userDAO, userToSave);
        return this.userService.save(userToSave);
    }

}
