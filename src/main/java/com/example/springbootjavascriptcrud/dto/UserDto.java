package com.example.springbootjavascriptcrud.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private Long id;

    @NotBlank
    private String firstName;
    private String lastName;
    @NotBlank
    @Column(nullable = false)
    private String username;
    @Size(min = 8, message = "Password min length 8")
    @NotBlank
    private String password;
}
