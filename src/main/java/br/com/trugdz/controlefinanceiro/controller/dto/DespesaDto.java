package br.com.trugdz.controlefinanceiro.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import br.com.trugdz.controlefinanceiro.model.Despesa;

public class DespesaDto {

    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
    private LocalDateTime dataCadastro = LocalDateTime.now();

    public DespesaDto(Despesa despesa) {
        this.id = despesa.getId();
        this.descricao = despesa.getDescricao();
        this.valor = despesa.getValor();
        this.data = despesa.getData();
        this.dataCadastro = despesa.getDataCadastro();
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

    public static List<DespesaDto> converter(List<Despesa> despesas) {
        return despesas.stream().map(DespesaDto::new).collect(Collectors.toList());
    }

}
