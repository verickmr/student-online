package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.respository.AlunoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class AlunService {

        @Autowired
        AlunoRespository alunoRespository;

        public void criarAluno(Aluno aluno){
            alunoRespository.save(aluno);
        }

    public List<Aluno> listAll(){
        return   alunoRespository.findAll();
    }

    public Optional<Aluno> findId(Long Id){
        return alunoRespository.findById(Id);
    }

    public void deleteId(Long Id){
        alunoRespository.deleteById(Id);
    }


}


