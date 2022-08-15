package br.com.trugdz.controlefinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trugdz.controlefinanceiro.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}
