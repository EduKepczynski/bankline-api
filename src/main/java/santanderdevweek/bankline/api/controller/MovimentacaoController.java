package santanderdevweek.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import santanderdevweek.bankline.api.dto.NovaMovimentacao;
import santanderdevweek.bankline.api.model.Movimentacao;
import santanderdevweek.bankline.api.model.repository.MovimentacaoRepository;
import santanderdevweek.bankline.api.service.MovimentacaoService;

@RestController		// 
@RequestMapping("/movimentacao")	// Rotas relacionadas à palavra movimentacao serão mapeadas. Ver no localhost:8080/movimentacao
public class MovimentacaoController {
	
	@Autowired		// Faz a busca no BD sem dar o 'new'.
	private MovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public List<Movimentacao> findAll(){		// Percorre o BD e lista todos para retorna-los
		return repository.findAll();		// Busca os dados no BD
	}
	
	@GetMapping("/{idConta}")		// Faz a listagem das movimentações de um ID de conta específico
	public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
		return repository.findByIdConta(idConta);
	}
	
	@PostMapping
	public void save(@RequestBody NovaMovimentacao movimentacao) {		// Método para incluir as movimentações na tabela do BD
		service.save(movimentacao);
		
	}
	

}
