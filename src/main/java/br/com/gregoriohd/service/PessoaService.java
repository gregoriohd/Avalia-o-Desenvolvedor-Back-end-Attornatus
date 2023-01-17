package br.com.gregoriohd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gregoriohd.exception.ResourceNotFoudException;
import br.com.gregoriohd.model.Endereco;
import br.com.gregoriohd.model.Pessoa;
import br.com.gregoriohd.repository.PessoaRepository;
import br.com.gregoriohd.share.PessoaDTO;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoService enderecoService;

	public List<PessoaDTO> obterPessoas() {

		List<Pessoa> pessoas = pessoaRepository.findAll();
		

		return pessoas.stream().map(pessoa -> new ModelMapper().map(pessoa, PessoaDTO.class))
				.collect(Collectors.toList());
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
