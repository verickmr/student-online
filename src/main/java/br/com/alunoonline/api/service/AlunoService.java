package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.respository.AlunoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService  {
    @Autowired
    AlunoRespository alunoRespository;

    public void criarAluno(Aluno aluno){
        alunoRespository.save(aluno);
    }
}
