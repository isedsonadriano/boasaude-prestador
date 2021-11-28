package br.com.boasaude.cadastro.prestador.infra.repository.orm;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import br.com.boasaude.cadastro.prestador.core.domain.vo.TipoPrestador;


@Entity
public class PrestadorJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;

	private String cnpj;

	private String cpf;

	@NotNull
	@Enumerated
	private TipoPrestador tipo;

	@NotNull
	private String razaoSocial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String user) {
		this.cnpj = user;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String password) {
		this.cpf = password;
	}

	public TipoPrestador getTipo() {
		return tipo;
	}

	public void setTipo(TipoPrestador gender) {
		this.tipo = gender;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
}
