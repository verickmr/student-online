package br.com.alunoonline.api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class HistoryResponse {
    private String nameAluno;
    private  String emailAluno;
    private  String cpfAluno;
    private List<DisciplinaResponse> disciplinaResponseList;
}
