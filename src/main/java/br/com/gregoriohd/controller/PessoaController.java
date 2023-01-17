package br.com.gregoriohd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gregoriohd.model.Pessoa;
import br.com.gregoriohd.service.PessoaService;
import br.com.gregoriohd.share.PessoaDTO;

@RestController
@RequestMapping("/v1/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<PessoaDTO>> obterPessoas() {
		List<PessoaDTO> pessoas = pessoaService.obterPessoas();
		return new ResponseEntity<List<PessoaDTO>>(pessoas, HttpStatus.OK);
	}

	@GetMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> obterPessoaPorId(@PathVariable Integer pessoaId) {
		Pessoa pessoa = pessoaService.obterPessoaPorId(pessoaId).get();
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Pessoa> adiconarPessoa(@RequestBody Pessoa pessoa) {
		Pessoa p = pessoaService.adicionarPessoa(pessoa);
		return new ResponseEntity<Pessoa>(p, HttpStatus.CREATED);
	}

	@DeleteMapping("/{pessoaId}")
	public ResponseEntity<Void> removePessoaPorId(@PathVariable Integer pessoaId) {
		pessoaService.removerPessoaPorId(pessoaId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PatchMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> atualizaPessoa(@PathVariable Integer pessoaId, @RequestBody Pessoa pessoa) {
		Pessoa p = pessoaService.atualizaPessoa(pessoaId, pessoa);
		return new ResponseEntity<Pessoa>(p, HttpStatus.OK);
	}

}
