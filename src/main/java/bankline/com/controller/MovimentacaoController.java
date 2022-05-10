package bankline.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankline.com.DTO.NovaMovimentacao;
import bankline.com.DTO.NovoCorrentista;
import bankline.com.model.Correntista;
import bankline.com.model.Movimentacao;
import bankline.com.repository.CorrentistaRepository;
import bankline.com.repository.MovimentacaoRepository;
import bankline.com.service.CorrentistaService;
import bankline.com.service.MovimentacaoService;

@RestController
@RequestMapping("movimentacao")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	@Autowired
	private MovimentacaoService movimentacaoService;
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return movimentacaoRepository.findAll();
	}
	@PostMapping
	public void save (@RequestBody NovaMovimentacao movimentacao) {
		movimentacaoService.save(movimentacao);
	}
}
