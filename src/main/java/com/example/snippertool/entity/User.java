package com.example.snippertool.entity;
import lombok.Data;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Data
public class User {
    private int id;
    private String email;
    private String password;
}
