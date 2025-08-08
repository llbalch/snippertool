package com.example.snippertool.entity;
import com.fasterxml.jackson.annotation.JsonTypeId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import lombok.Data;

@Entity
@Data
public class Snippet {

    private int id;
    private String code;
    private String language;
    private int userId;

}