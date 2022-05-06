package santanderdevweek.bankline.api.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import santanderdevweek.bankline.api.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
	
	public List<Movimentacao>findByIdConta(Integer idConta);

}
