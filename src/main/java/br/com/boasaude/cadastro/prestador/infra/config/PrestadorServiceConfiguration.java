package br.com.boasaude.cadastro.prestador.infra.config;

import br.com.boasaude.cadastro.prestador.core.repository.PrestadorRepository;
import br.com.boasaude.cadastro.prestador.core.service.PrestadorService;
import br.com.boasaude.cadastro.prestador.core.service.implementation.PrestadorServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class PrestadorServiceConfiguration {

	@Bean
    public PrestadorService clientService(PrestadorRepository repository){
        return new PrestadorServiceImpl(repository);
    }
}
