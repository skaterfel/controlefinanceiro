package br.com.trugdz.controlefinanceiro.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.trugdz.controlefinanceiro.model.Despesa;
import br.com.trugdz.controlefinanceiro.repository.DespesaRepository;

public class AtualizacaoDespesaForm {

    @NotNull
    @NotEmpty
    private String descricao;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private LocalDate data;

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

    public Despesa atualizar(Long id, DespesaRepository despesaRepository) {
        Despesa despesa = despesaRepository.getOne(id);
        despesa.setDescricao(descricao);
        despesa.setValor(valor);
        despesa.setData(data);
        return despesa;
    }

}
