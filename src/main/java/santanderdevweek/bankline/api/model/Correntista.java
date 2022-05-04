package santanderdevweek.bankline.api.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity		// Essa classe será uma entidade
@Table(name = "tab_correntista")	// Essa classe será salva em uma tabela com o nome definido
public class Correntista {
	
	@Id		// Define como chave primária do BD
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// Gera o número da chave automaticamente
	private Integer id;
	
	@Column(length = 20)	// Não é tão necessário, mas dá pra definir o tamanho da coluna
	private String cpf;
	
	@Column(length = 60)	// Isso é modelação do BD
	private String nome;
	
	@Embedded	// Essa classe tem mais de uma informação que deve ser guardada na tabela de correntista
	private Conta conta;	// Por isso devemos relacionar as duas.
	
	
	// Getters and Setters
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
