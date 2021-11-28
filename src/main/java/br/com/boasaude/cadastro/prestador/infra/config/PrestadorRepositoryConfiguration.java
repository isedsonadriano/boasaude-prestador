package br.com.boasaude.cadastro.prestador.infra.config;

import br.com.boasaude.cadastro.prestador.core.repository.PrestadorRepository;
import br.com.boasaude.cadastro.prestador.core.repository.implementation.PrestadorRepositoryImpl;
import br.com.boasaude.cadastro.prestador.infra.repository.PrestadorRepositoryMySql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrestadorRepositoryConfiguration {

    @Bean
    public PrestadorRepository clientRepository(PrestadorRepositoryMySql repository) {
        return new PrestadorRepositoryImpl(repository);
    }

}