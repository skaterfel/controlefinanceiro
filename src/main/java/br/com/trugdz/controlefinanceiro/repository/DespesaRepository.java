package br.com.trugdz.controlefinanceiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trugdz.controlefinanceiro.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    List<Despesa> findByDescricao(String descricao);

    List<Despesa> findByDescricaoContaining(String descrica);

}
