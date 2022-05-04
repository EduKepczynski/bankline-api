package santanderdevweek.bankline.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import santanderdevweek.bankline.api.dto.NovoCorrentista;
import santanderdevweek.bankline.api.model.Conta;
import santanderdevweek.bankline.api.model.Correntista;
import santanderdevweek.bankline.api.model.repository.CorrentistaRepository;

@Service
public class CorrentistaService {		// Esse é o método que vai incluir os dados no BD
	
	@Autowired
	private CorrentistaRepository repository;
	public void save(NovoCorrentista novoCorrentista) {
		Correntista correntista = new Correntista();	// Instancia um correntista
		correntista.setCpf(novoCorrentista.getCpf());	// Define o CPF
		correntista.setNome(novoCorrentista.getNome());	// Define o nome
		
		Conta conta = new Conta();		// Instancia uma conta
		conta.setSaldo(0.0);			// Define o saldo da conta como zero
		conta.setNumero(new Date().getTime());		// Gera um número de conta com base na data e hora
		
		correntista.setConta(conta);	// Define o número da conta
		repository.save(correntista);
		
	}

}
