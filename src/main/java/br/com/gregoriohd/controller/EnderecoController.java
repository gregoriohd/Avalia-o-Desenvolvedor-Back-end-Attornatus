package br.com.gregoriohd.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gregoriohd.model.Endereco;
import br.com.gregoriohd.model.Pessoa;
import br.com.gregoriohd.service.EnderecoService;
import br.com.gregoriohd.service.PessoaService;

@RestController
@RequestMapping("/v1/pessoas")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping("/{pessoaId}/enderecos")
	public ResponseEntity<Endereco> adicionarEndereco(@RequestBody Endereco endereco, @PathVariable Integer pessoaId) {
		Pessoa p = pessoaService.obterPessoaPorId(pessoaId).get();
				
		endereco.setPessoa(p);
		
		endereco = enderecoService.adicionarEndereco(endereco);
		
		return new ResponseEntity<Endereco>(endereco, HttpStatus.CREATED);
		
	}
	
//	@GetMapping("/enderecos")
//	public ResponseEntity<List<Endereco>> obterEnderecos(){
//		List<Endereco> enderecos = enderecoService.obterEnderecos();
//		
//		return new ResponseEntity<List<Endereco>>(enderecos, HttpStatus.OK);
//	}
	
	@GetMapping("/{pessoaId}/enderecos")
	public ResponseEntity<List<Endereco>> obterEnderecosPorPessoa(@PathVariable Integer pessoaId){
		List<Endereco> enderecos = enderecoService.obterEnderecoPessoa(pessoaId);
		
		return new ResponseEntity<List<Endereco>>(enderecos, HttpStatus.OK);
	}
	
	@GetMapping("/enderecos/{pessoaId}")
	public ResponseEntity<Endereco> obterEnderecosPorId(@PathVariable Integer pessoaId){
		Endereco endereco = enderecoService.obterEnderecoPorId(pessoaId);
		
		return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
	}
	
	@PatchMapping("/{pessoaId}/enderecos/{enderecoId}")
	public ResponseEntity<Endereco> atualizaEndereco(@PathVariable Integer pessoaId, @PathVariable Integer enderecoId, @RequestBody Endereco endereco) {
		Endereco e = enderecoService.atualizaEndereco(enderecoId, pessoaId, endereco);
		
		return new ResponseEntity<Endereco>(e, HttpStatus.OK);
	}
}
