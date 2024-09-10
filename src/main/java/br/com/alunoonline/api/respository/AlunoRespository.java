package br.com.alunoonline.api.respository;

import br.com.alunoonline.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRespository extends JpaRepository<Aluno,Long> {

}
