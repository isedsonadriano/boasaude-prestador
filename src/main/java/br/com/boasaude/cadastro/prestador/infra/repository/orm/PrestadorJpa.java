package br.com.boasaude.cadastro.prestador.infra.repository.orm;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.boasaude.cadastro.prestador.core.domain.enums.Status;
import br.com.boasaude.cadastro.prestador.core.domain.vo.ConselhoProfissional;
import br.com.boasaude.cadastro.prestador.core.domain.vo.TelefoneVO;
import br.com.boasaude.cadastro.prestador.core.domain.vo.TipoPrestador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "boasaude_prestador")
public class PrestadorJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String cpf;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoPrestador tipo;

	@NotNull
	@Embedded
	private TelefoneVO telefone;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	@Enumerated(EnumType.STRING)
	private ConselhoProfissional conselho;

	private String numeroNoConselho;

	private String cbos;

	private String cnes;

}
