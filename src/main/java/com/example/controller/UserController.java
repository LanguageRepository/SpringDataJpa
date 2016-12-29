package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable(value = "userId") Long userId) {
        return userService.getUser(userId);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto dto) {
        userService.saveUser(dto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserDto dto) {
        userService.updateUser(dto);
    }

    @RequestMapping(value = "/del/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

}
