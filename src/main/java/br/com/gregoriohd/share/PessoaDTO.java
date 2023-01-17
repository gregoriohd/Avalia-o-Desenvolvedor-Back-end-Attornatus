package br.com.gregoriohd.share;


import java.util.Date;
import java.util.List;

import br.com.gregoriohd.model.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
	
	private Integer id;
	private String nome;
	private Date dataNascimento;

	private List<Endereco> enderecos;

}
