package br.com.gregoriohd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoudException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoudException(String mensagem) {
		super(mensagem);
	}
}
