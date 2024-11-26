package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.respository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
        @Autowired
        ProfessorRepository professorRepository;
        public void criarProfessor(Professor professor){
            professorRepository.save(professor);
        }

    public List<Professor> listAll(){
        return   professorRepository.findAll();
    }

    public Optional<Professor> findId(Long Id){
        return professorRepository.findById(Id);
    }

    public void deleteId(Long Id){
        professorRepository.deleteById(Id);
    }

}

