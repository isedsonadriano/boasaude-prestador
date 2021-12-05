package br.com.boasaude.cadastro.prestador.core.domain.entity;

import br.com.boasaude.cadastro.prestador.core.domain.vo.TipoPrestador;

public class Prestador {

	private Long id;
	private String nome;
	private String cpf;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoPrestador getTipo() {
		return tipo;
	}

	public void setTipo(TipoPrestador tipo) {
		this.tipo = tipo;
	}

}
