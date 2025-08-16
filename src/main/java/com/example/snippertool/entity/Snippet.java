package com.example.snippertool.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name ="snippet")
@Setter
@Getter

public class Snippet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String code;

    @Column
    private String language;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}