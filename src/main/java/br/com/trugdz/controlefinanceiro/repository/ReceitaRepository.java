package br.com.trugdz.controlefinanceiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trugdz.controlefinanceiro.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findByDescricao(String descricao);

}
