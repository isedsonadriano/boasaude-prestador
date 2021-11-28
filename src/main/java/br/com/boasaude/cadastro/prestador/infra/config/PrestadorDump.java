package br.com.boasaude.cadastro.prestador.infra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import com.github.javafaker.Faker;

import br.com.boasaude.cadastro.prestador.core.domain.entity.Prestador;
import br.com.boasaude.cadastro.prestador.core.domain.vo.TipoPrestador;
import br.com.boasaude.cadastro.prestador.core.service.PrestadorService;
import br.com.boasaude.cadastro.prestador.core.util.Paginador;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class PrestadorDump {
	
	private static final int QUANTIDADE_PRESTADORES_DUMP = 1000;

	@Autowired
	private Faker faker;
	
	@Autowired
	private PrestadorService prestadorService;
	
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
		for (int i = 0; i < QUANTIDADE_PRESTADORES_DUMP; i++) {
			Prestador prestador = new Prestador();
			prestador.setId(faker.random().nextLong());
			prestador.setNome(faker.company().name());
			prestador.setRazaoSocial(prestador.getNome());
			prestador.setTipo(TipoPrestador.JURIDICA);
			prestador.setCpf(String.valueOf(faker.random().nextLong()));
			prestador.setCnpj(String.valueOf(faker.random().nextLong()));
			
			this.prestadorService.salvar(prestador);
		}
	}

}
