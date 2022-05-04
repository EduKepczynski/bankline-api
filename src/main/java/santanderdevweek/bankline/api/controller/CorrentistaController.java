package santanderdevweek.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import santanderdevweek.bankline.api.dto.NovoCorrentista;
import santanderdevweek.bankline.api.model.Correntista;
import santanderdevweek.bankline.api.model.repository.CorrentistaRepository;
import santanderdevweek.bankline.api.service.CorrentistaService;

@RestController		// 
@RequestMapping("/correntistas")	// Rotas relacionadas à palavra correntista serão mapeadas. Ver no localhost:8080/correntistas
public class CorrentistaController {
	
	@Autowired		// Faz a busca no BD sem dar o 'new'.
	private CorrentistaRepository repository;
	
	@Autowired
	private CorrentistaService service;
	
	@GetMapping
	public List<Correntista> findAll(){		// Percorre o BD e lista todos para retorna-los
		return repository.findAll();		// Busca os dados no BD
	}
	
	@PostMapping
	public void save(@RequestBody NovoCorrentista correntista) {		// Método para incluir correntistas na tabela do BD
		service.save(correntista);
		
	}
	

}
