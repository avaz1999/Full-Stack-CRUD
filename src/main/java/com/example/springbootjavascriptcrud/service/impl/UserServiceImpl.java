package com.example.springbootjavascriptcrud.service.impl;

import com.example.springbootjavascriptcrud.base.ApiResponse;
import com.example.springbootjavascriptcrud.base.ResponseMessage;
import com.example.springbootjavascriptcrud.dto.UserDto;
import com.example.springbootjavascriptcrud.entity.User;
import com.example.springbootjavascriptcrud.repository.UserRepository;
import com.example.springbootjavascriptcrud.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public ApiResponse<?> register(UserDto dto) {
        try {
            if (dto.getUsername() != null &&
                    userRepository.existsUserByUsername(dto.getUsername()) &&
                    dto.getPassword().length() > 8 &&
                    dto.getFirstName() != null) {
                User entity = User.toEntity(dto);
                userRepository.save(entity);
                return new ApiResponse<>(true, ResponseMessage.SUCCESS);
            }else return new ApiResponse<>(false,ResponseMessage.OBJECT_IS_NULL);
        }catch (Throwable e){
            e.printStackTrace();
        }
        return new ApiResponse<>(false,ResponseMessage.SERVER_ERROR);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public User edit(User user, Long id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            byId.get().setFirstName(user.getFirstName() != null ? user.getFirstName() : byId.get().getFirstName());
            byId.get().setLastName(user.getLastName() != null ? user.getLastName() : byId.get().getLastName());
            byId.get().setUsername(user.getUsername() != null ? user.getUsername() : byId.get().getUsername());
            byId.get().setPassword(user.getPassword() != null ? user.getPassword() : byId.get().getPassword());
            return byId.get();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
