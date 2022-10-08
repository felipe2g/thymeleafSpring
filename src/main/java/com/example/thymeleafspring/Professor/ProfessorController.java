package com.example.thymeleafspring.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("professor")
public class ProfessorController {
    @Autowired
    JdbcTemplate jdbc;

    @GetMapping("")
    public String getProfessor() {
        return "professor";
    }
}
