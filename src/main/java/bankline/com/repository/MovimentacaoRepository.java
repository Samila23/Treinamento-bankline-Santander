package bankline.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bankline.com.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{

}
