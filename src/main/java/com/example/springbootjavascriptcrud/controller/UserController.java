package com.example.springbootjavascriptcrud.controller;

import com.example.springbootjavascriptcrud.dto.UserDto;
import com.example.springbootjavascriptcrud.entity.User;
import com.example.springbootjavascriptcrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @PostMapping
    public void register(@RequestBody UserDto dto){
        userService.register(dto);
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }
    @GetMapping("{/id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }
    @PutMapping("{/id}")
    public User edit(@RequestBody User user,@PathVariable Long id){
        return userService.edit(user,id);
    }
    @DeleteMapping("{/id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
