package br.com.trugdz.controlefinanceiro.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.trugdz.controlefinanceiro.model.Receita;
import br.com.trugdz.controlefinanceiro.repository.ReceitaRepository;

public class AtualizacaoReceitaForm {

    private String descricao;
    private BigDecimal valor;
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

    public Receita atualizar(Long id, ReceitaRepository receitaRepository) {
        Receita receita = receitaRepository.getOne(id);
        receita.setDescricao(descricao);
        receita.setValor(valor);
        receita.setData(data);
        return receita;

    }

}
