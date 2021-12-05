package br.com.boasaude.cadastro.prestador.infra.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
