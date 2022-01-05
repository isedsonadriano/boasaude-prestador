package br.com.boasaude.cadastro.prestador.core.domain.vo;

public class TelefoneVO {

	private String numeroCompleto;

	public TelefoneVO(String telefone) {
		this.numeroCompleto = telefone;
	}
	
	@Deprecated
	public TelefoneVO() {
	}

	public String getNumeroCompleto() {
		return numeroCompleto;
	}

	public void setNumeroCompleto(String numeroCompleto) {
		this.numeroCompleto = numeroCompleto;
	}
}
