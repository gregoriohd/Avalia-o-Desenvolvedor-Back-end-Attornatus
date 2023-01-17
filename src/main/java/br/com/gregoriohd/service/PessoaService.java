package br.com.gregoriohd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gregoriohd.exception.ResourceNotFoudException;
import br.com.gregoriohd.model.Endereco;
import br.com.gregoriohd.model.Pessoa;
import br.com.gregoriohd.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoService enderecoService;

	public List<Pessoa> obterPessoas() {
		return pessoaRepository.findAll();
	}

	public Optional<Pessoa> obterPessoaPorId(Integer id) {
		return Optional.of(pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoudException("Pessoa com ID: " + id + " não encontrado.")));
	}

	@Transactional
	public Pessoa adicionarPessoa(Pessoa pessoa) {

		Pessoa p = pessoaRepository.save(pessoa);

		if (p.getEnderecos() != null) {
			List<Endereco> enderecos = new ArrayList<>();

			for (Endereco end : p.getEnderecos()) {
				end.setPessoa(p);
				enderecos.add(end);
			}

			enderecoService.adicionarEnderecos(enderecos);
		}

		return p;
	}

	public void removerPessoaPorId(Integer id) {

		Pessoa p = obterPessoaPorId(id).get();
		pessoaRepository.delete(p);
	}

	public Pessoa atualizaPessoa(Integer id, Pessoa pessoa) {

		
		pessoa.setId(obterPessoaPorId(id).get().getId());
		pessoa.setEnderecos(null);
		
		return adicionarPessoa(pessoa);
		
		

	}


}
