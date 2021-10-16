package br.com.testesonda.api.config.validation;

public class ErroFormularioDto {
	
	private String campoErro;
	private String msgErro;
	
	public ErroFormularioDto(String campoErro, String msgErro) {
		this.campoErro = campoErro;
		this.msgErro = msgErro;
	}

	public String getCampoErro() {
		return campoErro;
	}

	public String getMsgErro() {
		return msgErro;
	}
	
	
	

}
