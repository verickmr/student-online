package br.com.alunoonline.api.dtos;

import br.com.alunoonline.api.enuns.Status;
import lombok.Data;


@Data
public class DisciplinaResponse {
    private String nameDisciplina;
    private  String nameProfessor;
    private Double nota1;
    private Double nota2;
    private  Double media;
    private Status status;
}
