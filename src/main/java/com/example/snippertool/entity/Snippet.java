package com.example.snippertool.entity;
import lombok.Data;

@Data
public class Snippet {
    private int id;
    private String code;
    private String language;
    private int userId;

}