package br.com.gregoriohd.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ENDERECO")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String logradouro;
	private String cep;
	private Integer numero;
	private String cidade;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
}
