package santanderdevweek.bankline.api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable		// Define que ela está relacionada à função respectiva na classe Correntista
public class Conta {
	
	@Column(name = "conta_numero")	// Define como vai ser salvo no BD
	private Long numero;
	
	@Column(name = "conta_saldo")	// Define como vai ser salvo no BD
	private Double saldo;
	
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
	

}
