package com.example.snippertool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SnippertoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnippertoolApplication.class, args);
    }

}
