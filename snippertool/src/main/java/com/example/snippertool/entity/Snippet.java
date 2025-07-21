package com.example.snippertool.entity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
public class Snippet {
    private int id;
    private String code;
    private String language;
    private int userId;

}