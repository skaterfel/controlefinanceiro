package br.com.trugdz.controlefinanceiro.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.trugdz.controlefinanceiro.model.Receita;

public class DetalhesDaReceitaDto {

    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
    private LocalDateTime dataCadastro = LocalDateTime.now();

    public DetalhesDaReceitaDto(Receita receita) {
        this.id = receita.getId();
        this.descricao = receita.getDescricao();
        this.valor = receita.getValor();
        this.data = receita.getData();
        this.dataCadastro = receita.getDataCadastro();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
