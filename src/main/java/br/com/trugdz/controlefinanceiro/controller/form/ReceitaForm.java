package br.com.trugdz.controlefinanceiro.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.trugdz.controlefinanceiro.model.Receita;

public class ReceitaForm {
    @NotNull
    @NotEmpty
    @Length(min = 5)
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

    public Receita converter() {
        return new Receita(descricao, valor, data);
    }

}
