package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/professor")
public class ProfessorControler {
    @Autowired
    ProfessorService professorService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)

    public void criarProfessor(@RequestBody Professor professor){
        professorService.criarProfessor(professor);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> getAll(){
        return professorService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Professor> findId(@PathVariable Long id){
        return professorService.findId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteId(@PathVariable Long id){
        professorService.deleteId(id);
    }
}
