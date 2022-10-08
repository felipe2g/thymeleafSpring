package com.example.thymeleafspring.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "professor/professor";
    }

    @GetMapping("novo")
    public String getShowProfessorForm(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/novo";
    }

    @PostMapping("novo")
    public String postProfessor(Professor professor) {
        jdbc.update("INSERT INTO professor(nome) VALUES (?)", professor.getNome());

        return "redirect:/professor/novo";
    }

    @GetMapping("delete")
    public String excluirProf(@RequestParam(value = "id", required = true) Integer cod) {
        jdbc.update("delete from professor where id = ?", cod);
        return "redirect:/professor";
    }
}
