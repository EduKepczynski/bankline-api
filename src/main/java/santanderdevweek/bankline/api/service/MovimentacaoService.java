package santanderdevweek.bankline.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import santanderdevweek.bankline.api.dto.NovaMovimentacao;
import santanderdevweek.bankline.api.model.Correntista;
import santanderdevweek.bankline.api.model.Movimentacao;
import santanderdevweek.bankline.api.model.MovimentacaoTipo;
import santanderdevweek.bankline.api.model.repository.CorrentistaRepository;
import santanderdevweek.bankline.api.model.repository.MovimentacaoRepository;

@Service		// Vai incluir as movimentações no BD
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;	// Inserido para atualizar o saldo do cliente após as movimentações
	
	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();		// Instancia nova movimentação
		
		// O valor pode ser somado ou subtraído do saldo dependendo da operação (RECEITA ou DESPESA)
		Double valor = novaMovimentacao.getValor();
		if(novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA) valor = valor * -1;
		// Se for DESPESA, multiplica por -1 pro valor ficar negativo e subtrair do saldo
		 
		// Essa expressão toda pode ser resumida dessa forma:
		// Double valor = novaMovimentacao.getTipo()==MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
		
		
		movimentacao.setDataHora(LocalDateTime.now()); 		// Salva a hora da movimentação
		movimentacao.setDescricao(novaMovimentacao.getDescricao());		// Define a descrição
		movimentacao.setIdConta(novaMovimentacao.getIdConta()); 		// Define o id da conta
		movimentacao.setTipo(novaMovimentacao.getTipo());				// Define o tipo
		movimentacao.setValor(valor);									// Define o valor. Já está positivo ou negativo conforme a operação
		
		// Inserido para atualizar o saldo do cliente após as movimentações
		// Primeiro pegamos o Id da conta que houve a movimentação
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if(correntista != null) {		// Se a movimentação não for nula, atualizamos o saldo
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		
		
		repository.save(movimentacao);
		
		
	}
	
}
