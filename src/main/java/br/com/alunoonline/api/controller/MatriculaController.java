package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.HistoryResponse;
import br.com.alunoonline.api.dtos.UpdateNotasRequest;
import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.model.Matricula;
import br.com.alunoonline.api.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {
    @Autowired
    MatriculaService matriculaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void  createMatricula(@RequestBody Matricula matricula){
        matriculaService.createMatricula(matricula);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void  blockMatricula(@PathVariable Long id){
        matriculaService.blockMatricula(id);
    }

    @PatchMapping("/notas/{matriculaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  updateNotas(@RequestBody UpdateNotasRequest updateNotasRequest, @PathVariable Long matriculaId ){
        matriculaService.updateNotas(matriculaId, updateNotasRequest);
    }

    @GetMapping("/historico/{alunoId}")
    @ResponseStatus(HttpStatus.OK)
    public HistoryResponse emitirHistorico(@PathVariable Long alunoId) {
        return matriculaService.generateHistory(alunoId);
    }

}

