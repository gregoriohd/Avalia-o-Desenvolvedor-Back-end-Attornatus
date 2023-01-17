package br.com.gregoriohd.exception;

public class ErrorMessage {

	private String titulo;
	private Integer status;
	private String menssagem;
	
	

	public ErrorMessage(String titulo, Integer status, String menssagem) {
		this.titulo = titulo;
		this.status = status;
		this.menssagem = menssagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMenssagem() {
		return menssagem;
	}

	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}

}
