package br.com.gregoriohd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gregoriohd.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
