package br.com.forum.config.validacao;

public class MensagemErroDto {

	private String campo;
	private String mensagem;
	
	public MensagemErroDto(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
	
}
