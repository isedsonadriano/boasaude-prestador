package br.com.boasaude.cadastro.prestador.core.domain.entity;

import br.com.boasaude.cadastro.prestador.core.domain.enums.Status;
import br.com.boasaude.cadastro.prestador.core.domain.vo.ConselhoProfissional;
import br.com.boasaude.cadastro.prestador.core.domain.vo.TelefoneVO;
import br.com.boasaude.cadastro.prestador.core.domain.vo.TipoPrestador;

public class Prestador {

	private Long id;
	private String nome;
	private String cpf;
	private TipoPrestador tipo;
	private TelefoneVO telefone;
	private Status status;
	private ConselhoProfissional conselho;
	private String numeroNoConselho;
	private String cbos;
	private String cnes;

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TelefoneVO getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefoneVO telefone) {
		this.telefone = telefone;
	}

	public ConselhoProfissional getConselho() {
		return conselho;
	}

	public void setConselho(ConselhoProfissional conselho) {
		this.conselho = conselho;
	}

	public String getNumeroNoConselho() {
		return numeroNoConselho;
	}

	public void setNumeroNoConselho(String numeroNoConselho) {
		this.numeroNoConselho = numeroNoConselho;
	}

	public String getCnes() {
		return cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = cnes;
	}

	public String getCbos() {
		return cbos;
	}

	public void setCbos(String cbos) {
		this.cbos = cbos;
	}

}
