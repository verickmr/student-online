package br.com.alunoonline.api.controller;


import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplina")

public class DisciplinaController {
    @Autowired
    DisciplinaService disciplinaService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void  createDisciplina(@RequestBody  Disciplina disciplina){
        disciplinaService.createDisciplina(disciplina);
    }

    @GetMapping("/professor/{professorId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Disciplina> listDisciplinaProf(@PathVariable Long professorId){
        return disciplinaService.listDisciplinaProf(professorId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Disciplina> getAll(){
        return disciplinaService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Disciplina> findId(@PathVariable Long id){
        return disciplinaService.findId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteId(@PathVariable Long id){
        disciplinaService.deleteId(id);
    }
}
