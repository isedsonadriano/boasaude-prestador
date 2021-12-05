package br.com.boasaude.cadastro.prestador.core.domain.entity;

import br.com.boasaude.cadastro.prestador.core.domain.vo.TipoPrestador;

public class Prestador {
	
	private Long id;
	private String nome;
	private String cnpj;
	private String cpf;
	private String razaoSocial;

	private TipoPrestador tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public TipoPrestador getTipo() {
		return tipo;
	}

	public void setTipo(TipoPrestador tipo) {
		this.tipo = tipo;
	}

}
