package br.com.boasaude.cadastro.prestador.infra.config;

import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.boasaude.cadastro.prestador.application.prestador.dto.request.v1.PrestadorRequest;
import br.com.boasaude.cadastro.prestador.core.domain.entity.Prestador;
import br.com.boasaude.cadastro.prestador.core.domain.enums.Status;
import br.com.boasaude.cadastro.prestador.core.domain.vo.ConselhoProfissional;
import br.com.boasaude.cadastro.prestador.core.domain.vo.TelefoneVO;
import br.com.boasaude.cadastro.prestador.core.domain.vo.TipoPrestador;

@Configuration
public class ModelMapperConfiguration {

	@Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(buildPrestadorRequestToPrestador());
        return modelMapper;
    }

    private PropertyMap<PrestadorRequest, Prestador> buildPrestadorRequestToPrestador() {
        PropertyMap<PrestadorRequest, Prestador> orderMap = new PropertyMap<PrestadorRequest, Prestador>() {
            protected void configure() {
                map().setTelefone(new TelefoneVO(source.getTelefone()));
                map().setCbos(source.getCbos());
                map().setCnes(source.getCnes());
                if (source.getConselho() != null)
                    map().setConselho(ConselhoProfissional.valueOf(source.getConselho()));
                map().setCpf(source.getCpf());
                map().setNome(source.getNome());
                map().setNumeroNoConselho(source.getNumeroNoConselho());
                if (source.getStatus() != null)
                    map().setStatus(Status.valueOf(source.getStatus()));
                if (source.getTipo() != null)
                    map().setTipo(TipoPrestador.valueOf(source.getTipo()));
            }
          };
          
          return orderMap;
	}

}
