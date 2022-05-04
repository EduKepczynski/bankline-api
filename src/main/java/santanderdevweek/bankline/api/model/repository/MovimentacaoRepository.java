package santanderdevweek.bankline.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import santanderdevweek.bankline.api.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

}
