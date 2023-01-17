package br.com.gregoriohd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gregoriohd.exception.ResourceNotFoudException;
import br.com.gregoriohd.model.Endereco;
import br.com.gregoriohd.model.Pessoa;
import br.com.gregoriohd.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PessoaService pessoaService;

	public Endereco adicionarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public List<Endereco> adicionarEnderecos(List<Endereco> enderecos) {
		return enderecoRepository.saveAll(enderecos);
	}

	public List<Endereco> obterEnderecos() {
		return enderecoRepository.findAll();
	}

	public List<Endereco> obterEnderecoPessoa(Integer pessoaId) {

		Pessoa p = pessoaService.obterPessoaPorId(pessoaId).get();

		return p.getEnderecos();

	}

	public Endereco obterEnderecoPorId(Integer id) {
		return enderecoRepository.findById(id).orElseThrow(() -> new ResourceNotFoudException("Endereco com ID: " + id + " não encontrado."));

	}

	public Endereco atualizaEndereco(Integer enderecoId, Integer pessoaId, Endereco endereco) {

		Pessoa pessoa = pessoaService.obterPessoaPorId(pessoaId).get();
		
		obterEnderecoPorId(enderecoId);
		
		Pessoa p = new Pessoa();
		p.setId(pessoaId);
		p.setNome(pessoa.getNome());
		p.setDataNascimento(pessoa.getDataNascimento());
		
		if(endereco.getPrincipal()) {
			for(Endereco e : pessoa.getEnderecos()) {
				if(e.getId() != enderecoId) {
					e.setPrincipal(false);
				}
			}
		}
		
		endereco.setId(enderecoId);
		endereco.setPessoa(p);
		
		return adicionarEndereco(endereco);
	}
}



