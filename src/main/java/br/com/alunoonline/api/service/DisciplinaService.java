package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.respository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    DisciplinaRepository disciplinaRepository;

    public void createDisciplina(Disciplina disciplina){
        disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listDisciplinaProf(Long professorId){
        return  disciplinaRepository.findByProfessorId(professorId);

    }

    public List<Disciplina> listAll(){
        return   disciplinaRepository.findAll();
    }

    public Optional<Disciplina> findId(Long Id){
        return disciplinaRepository.findById(Id);
    }

    public void deleteId(Long Id){
        disciplinaRepository.deleteById(Id);
    }
}
