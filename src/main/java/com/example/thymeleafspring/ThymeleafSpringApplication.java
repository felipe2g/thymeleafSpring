package com.example.thymeleafspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ThymeleafSpringApplication implements CommandLineRunner {
    @Autowired
    JdbcTemplate jdbc;

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        jdbc.execute("DROP TABLE IF EXISTS professor");
        jdbc.execute("CREATE TABLE professor(id int auto_increment, nome varchar(20))");
        jdbc.execute("INSERT INTO professor(nome) VALUES ('Felipe'), ('João Kléber'), ('Lucas')");
    }
}
