package br.com.trugdz.controlefinanceiro.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.trugdz.controlefinanceiro.controller.dto.DetalhesDaReceitaDto;
import br.com.trugdz.controlefinanceiro.controller.dto.ReceitaDto;
import br.com.trugdz.controlefinanceiro.controller.form.AtualizacaoReceitaForm;
import br.com.trugdz.controlefinanceiro.controller.form.ReceitaForm;
import br.com.trugdz.controlefinanceiro.model.Receita;
import br.com.trugdz.controlefinanceiro.repository.ReceitaRepository;

@RestController
@RequestMapping("/receitas")
public class ReceitasController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @GetMapping // Listar todas receitas
    public List<ReceitaDto> listar(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            List<Receita> receitas = receitaRepository.findAll();
            return ReceitaDto.converter(receitas);
        } else {
            List<Receita> receitas = receitaRepository.findByDescricao(descricao);
            return ReceitaDto.converter(receitas);
        }
    }

    @PostMapping // Cadastrar nova receita
    public ResponseEntity<ReceitaDto> cadastrar(@RequestBody ReceitaForm form, UriComponentsBuilder uriBuilder) {
        Receita receita = form.converter();

        receitaRepository.save(receita);

        URI uri = uriBuilder.path("/receitas/{id}").buildAndExpand(receita.getId()).toUri();

        return ResponseEntity.created(uri).body(new ReceitaDto(receita));
    }

    @GetMapping("/{id}") // Detalhar receita pelo id
    public ResponseEntity<DetalhesDaReceitaDto> detalhar(@PathVariable Long id) {
        Optional<Receita> receita = receitaRepository.findById(id);
        if (receita.isPresent()) {
            return ResponseEntity.ok(new DetalhesDaReceitaDto(receita.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}") // Atualizar receita pelo ID
    public ResponseEntity<ReceitaDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoReceitaForm form) {
        Optional<Receita> optional = receitaRepository.findById(id);
        if (optional.isPresent()) {
            Receita receita = form.atualizar(id, receitaRepository);
            return ResponseEntity.ok(new ReceitaDto(receita));
        }
        return ResponseEntity.notFound().build();
    }
}
