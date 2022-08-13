package br.com.trugdz.controlefinanceiro.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.trugdz.controlefinanceiro.model.Receita;

public class ReceitaDto {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
    private LocalDateTime dataCadastro = LocalDateTime.now();

    public ReceitaDto(Receita receita) {
        this.id = receita.getId();
        this.descricao = receita.getDescricao();
        this.valor = receita.getValor();
        this.data = receita.getData();
        this.dataCadastro = receita.getDataCadastro();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public static List<ReceitaDto> converter(List<Receita> receitas) {

        return receitas.stream().map(ReceitaDto::new).collect(Collectors.toList());
    }

}
