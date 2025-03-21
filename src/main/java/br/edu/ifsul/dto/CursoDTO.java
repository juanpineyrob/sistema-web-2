package br.edu.ifsul.dto;

import java.time.LocalDate;

import br.edu.ifsul.entity.Curso;

public class CursoDTO {
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private String foto;

    private Long professorId;
    private Long categoriaId;

    public CursoDTO() {
    }

    public CursoDTO(String nome, String descricao, LocalDate dataInicio, LocalDate dataFinal, String foto,
            Long professorId, Long categoriaId) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.foto = foto;
        this.professorId = professorId;
        this.categoriaId = categoriaId;
    }

    public CursoDTO(Curso entity) {
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
        this.dataInicio = entity.getDataInicio();
        this.dataFinal = entity.getDataFinal();
        this.foto = entity.getFoto();
        this.professorId = entity.getProfessor().getId();
        this.categoriaId = entity.getCategoria().getId();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public String getFoto() {
        return foto;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }
}
