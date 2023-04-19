package com.example.springbootjavascriptcrud.service;

import com.example.springbootjavascriptcrud.base.ApiResponse;
import com.example.springbootjavascriptcrud.dto.UserDto;
import com.example.springbootjavascriptcrud.entity.User;

import java.util.List;

public interface UserService {
ApiResponse<?> register(UserDto dto);

    List<User> getAllUser();

    User getById(Long id);

    User edit(User user, Long id);

    void delete(Long id);
}
