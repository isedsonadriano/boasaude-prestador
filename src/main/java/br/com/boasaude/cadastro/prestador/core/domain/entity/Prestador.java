package br.com.boasaude.cadastro.prestador.core.domain.entity;

import br.com.boasaude.cadastro.prestador.core.domain.enums.Status;
import br.com.boasaude.cadastro.prestador.core.domain.vo.ConselhoProfissional;
import br.com.boasaude.cadastro.prestador.core.domain.vo.TelefoneVO;
import br.com.boasaude.cadastro.prestador.core.domain.vo.TipoPrestador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
