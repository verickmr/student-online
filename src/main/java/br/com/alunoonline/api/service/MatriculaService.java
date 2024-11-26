package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.DisciplinaResponse;
import br.com.alunoonline.api.dtos.HistoryResponse;
import br.com.alunoonline.api.dtos.UpdateNotasRequest;
import br.com.alunoonline.api.enuns.Status;
import br.com.alunoonline.api.model.Matricula;
import br.com.alunoonline.api.respository.MatriculaRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculaService {
    public static final double MEDIA_PARA_APROVAÇÃO = 7.0;
    @Autowired
    MatriculaRpository matriculaRpository;

   public void createMatricula(Matricula matricula){
      matricula.setStatus(Status.CURSANDO);
       matriculaRpository.save(matricula);
    }

   public void blockMatricula(Long matriculaId){
       Matricula matricula = matriculaRpository.findById(matriculaId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"matricula"));
       if (!Status.CURSANDO.equals(matricula.getStatus())){
           throw  new ResponseStatusException(HttpStatus.BAD_REQUEST ,"só é possivel trancar uma matricula com o status de MATRICULADO");
       }
       matricula.setStatus(Status.TRANCADO);
       matriculaRpository.save(matricula);
    }
    public  void  updateNotas(Long matriculaId, UpdateNotasRequest updateNotasRequest){
        Matricula matricula = matriculaRpository.findById(matriculaId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"matricula"));
        if (updateNotasRequest.getNota1() != null){
            matricula.setNota1(updateNotasRequest.getNota1());
        }
        if (updateNotasRequest.getNota2() != null){
            matricula.setNota2(updateNotasRequest.getNota2());
        }
        calcMedia(matricula);
        matriculaRpository.save(matricula);
    }


    private  Double calcMedia(Matricula matricula){
       Double nota1 = matricula.getNota1();
       Double nota2 = matricula.getNota2();
       Double media;

        if (nota2 != null && nota1 != null) {
             media = (nota1 + nota2)/2;
            matricula.setStatus(media >= MEDIA_PARA_APROVAÇÃO ? Status.APROVADO : Status.REPROVADO);
            return media;
        }
        return null;
    }

    public HistoryResponse generateHistory(Long alunoId){
       List<Matricula> matriculaList = matriculaRpository.findByAlunoId(alunoId);

        if (matriculaList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"esse aluno não possui matriculas");
        }
        HistoryResponse history = new HistoryResponse();
        history.setNameAluno(matriculaList.get(0).getAluno().getName());
        history.setEmailAluno(matriculaList.get(0).getAluno().getEmail());
        history.setCpfAluno(matriculaList.get(0).getAluno().getCpf());

        List<DisciplinaResponse> disciplinaList = new ArrayList<>();

        for(Matricula matricula : matriculaList){
            DisciplinaResponse disciplinaAluno = new DisciplinaResponse();
            disciplinaAluno.setNameProfessor(matricula.getDisciplina().getProfessor().getName());
            disciplinaAluno.setNameDisciplina(matricula.getDisciplina().getName());
            disciplinaAluno.setNota1(matricula.getNota1());
            disciplinaAluno.setNota2    (matricula.getNota2());

            disciplinaAluno.setMedia(calcMedia(matricula));
            disciplinaAluno.setStatus(matricula.getStatus());
            disciplinaList.add(disciplinaAluno);
        }
        history.setDisciplinaResponseList(disciplinaList);


        return history;
    }
}

