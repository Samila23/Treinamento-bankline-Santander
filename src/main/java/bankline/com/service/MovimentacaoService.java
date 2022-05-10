package bankline.com.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankline.com.DTO.NovaMovimentacao;
import bankline.com.model.Correntista;
import bankline.com.model.Movimentacao;
import bankline.com.model.MovimentacaoTipo;
import bankline.com.repository.CorrentistaRepository;
import bankline.com.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();
		//Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * 1;
		Double valor = novaMovimentacao.getValor();
		if (novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA) {
			valor = valor * -1;
		}
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());			
		movimentacao.setValor(valor);
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if ( correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		movimentacaoRepository.save(movimentacao);
			
	}

}
