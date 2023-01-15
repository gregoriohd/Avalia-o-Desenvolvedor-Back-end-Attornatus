package br.com.gregoriohd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gregoriohd.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
