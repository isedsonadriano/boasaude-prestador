package br.com.boasaude.cadastro.prestador.infra.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import br.com.boasaude.cadastro.prestador.core.domain.entity.Prestador;
import br.com.boasaude.cadastro.prestador.core.domain.vo.TipoPrestador;
import br.com.boasaude.cadastro.prestador.core.service.PrestadorService;
import br.com.boasaude.cadastro.prestador.core.util.Paginador;
import br.com.boasaude.cadastro.prestador.integration.ConsultaPrestadores;
import br.com.boasaude.cadastro.prestador.integration.dto.PrestadorDTO;
import br.com.boasaude.cadastro.prestador.integration.dto.PrestadoresDTO;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class PrestadorDump {
	
	
	@Autowired
	private PrestadorService prestadorService;
	
	@Autowired
	private ConsultaPrestadores consultaPrestadores;
	
	@Autowired
	protected ModelMapper modelMapper;
	
	
	@EventListener(classes = ContextRefreshedEvent.class )
	public void iniciarBancoDeDados () {
		log.info("Início inserção prestadores");
		if(isBancoVazio()) {
			inserirPrestadoresDb();
		}
		log.info("Fim inserção prestadores");
	}

	private boolean isBancoVazio() {
		return this.prestadorService.capturarTodos(new Paginador()).size() == 0;
	}

	private void inserirPrestadoresDb() {
		PrestadoresDTO prestadores = consultaPrestadores.consulta();
		for (PrestadorDTO dto : prestadores.getPrestadores()) {
			Prestador prestador = new Prestador();
			prestador.setCpf(dto.getCpf());
			prestador.setId(dto.getId());
			prestador.setNome(dto.getNome());
			prestador.setTipo(TipoPrestador.MEDICO);
			this.prestadorService.salvar(prestador);
		}
	}

}
