package br.com.alunoonline.api.respository;

import br.com.alunoonline.api.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRpository extends JpaRepository<Matricula,Long> {
    List<Matricula> findByAlunoId(Long alunoId);

}
