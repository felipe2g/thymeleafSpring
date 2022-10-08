package com.example.thymeleafspring.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("professor")
public class ProfessorController {
    @Autowired
    JdbcTemplate jdbc;

    @GetMapping("")
    public String getProfessor(Model model) {
        List<Professor> professores = jdbc.query("SELECT id, nome from professor", (rs, rowNum) -> new Professor(rs.getLong("id"), rs.getString("nome")));
        model.addAttribute("professores", professores);

        return "professor";
    }
}
