package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/alunos")
public class AlunoContoller {
    @Autowired
    AlunService alunoService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)

    public void criarAluno(@RequestBody Aluno aluno){
        alunoService.criarAluno(aluno);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> getAll(){
       return alunoService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> findId(@PathVariable Long id){
        return alunoService.findId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteId(@PathVariable Long id){
        alunoService.deleteId(id);
    }


    }
