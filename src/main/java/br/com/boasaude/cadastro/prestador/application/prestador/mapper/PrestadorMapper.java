package br.com.boasaude.cadastro.prestador.application.prestador.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.boasaude.cadastro.prestador.application.prestador.dto.request.v1.PrestadorRequest;
import br.com.boasaude.cadastro.prestador.application.prestador.dto.response.v1.PrestadorResponse;
import br.com.boasaude.cadastro.prestador.core.domain.entity.Prestador;
import br.com.boasaude.cadastro.prestador.infra.repository.orm.PrestadorJpa;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class PrestadorMapper {
  
  private PrestadorMapper() {}

  private static final MapperFactory factoryPrestadorRequestToPrestador;
  private static final MapperFactory factoryPrestadorToPrestadorJpa;
  private static final MapperFactory factoryPrestadorToPrestadorResponse;
  
  static {
    factoryPrestadorRequestToPrestador = buildPrestadorRequestToPrestador();
    factoryPrestadorToPrestadorJpa = buildPrestadorToPrestadorJpa();
    factoryPrestadorToPrestadorResponse = buildPrestadorToPrestadorResponse();
  }

  public static Prestador prestadorRequestToPrestador(PrestadorRequest prestadorRequest) {
    return (Prestador) map(factoryPrestadorRequestToPrestador.getMapperFacade(), prestadorRequest, Prestador.class);
  }

  public static PrestadorJpa prestadorToPrestadorJpa(Prestador prestador) {
    return (PrestadorJpa) map(factoryPrestadorToPrestadorJpa.getMapperFacade(), prestador, PrestadorJpa.class);
  }

  public static Prestador prestadorJpaToPrestador(PrestadorJpa prestadorJpa) {
    return (Prestador) map(factoryPrestadorToPrestadorJpa.getMapperFacade(), prestadorJpa, Prestador.class);
  }

  public static PrestadorResponse prestadorToPrestadorResponse(Prestador prestador) {
    return (PrestadorResponse) map(factoryPrestadorToPrestadorResponse.getMapperFacade(), prestador, PrestadorResponse.class);
  }

  private static MapperFactory buildPrestadorRequestToPrestador() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		mapperFactory.classMap(PrestadorRequest.class, Prestador.class)
				.field("nome", "nome")
				.field("cpf", "cpf")
				.field("tipo", "tipo")
				.field("telefone", "telefone.numeroCompleto")
				.field("status", "status")
        .field("conselho", "conselho")
        .field("numeroNoConselho", "numeroNoConselho")
        .field("cbos", "cbos")
        .field("cnes", "cnes")
				.register();
		return mapperFactory;
	}

  private static MapperFactory buildPrestadorToPrestadorJpa() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		mapperFactory.classMap(Prestador.class, PrestadorJpa.class)
        .field("id", "id")
				.field("nome", "nome")
				.field("cpf", "cpf")
				.field("tipo", "tipo")
				.field("telefone", "telefone")
				.field("status", "status")
        .field("conselho", "conselho")
        .field("numeroNoConselho", "numeroNoConselho")
        .field("cbos", "cbos")
        .field("cnes", "cnes")
				.register();
		return mapperFactory;
	}

  private static MapperFactory buildPrestadorToPrestadorResponse() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		mapperFactory.classMap(Prestador.class, PrestadorResponse.class)
        .field("id", "id")
				.field("nome", "nome")
				.field("cpf", "cpf")
				.field("tipo", "tipo")
				.field("telefone.numeroCompleto", "telefone")
				.field("status", "status")
        .field("conselho", "conselho")
        .field("numeroNoConselho", "numeroNoConselho")
        .field("cbos", "cbos")
        .field("cnes", "cnes")
				.register();
		return mapperFactory;
	}

  @SuppressWarnings({ "rawtypes", "unchecked" })
	private static List map(final MapperFacade mapper, final List source, final Class destType) {
		if (mapper != null && source != null) {
			List dest = new ArrayList();
			dest.addAll(mapper.mapAsList(source, destType));
			return dest;
		}
		return Collections.emptyList();
	}


	@SuppressWarnings({ "rawtypes" })
	private static Object map(MapperFacade mapper, Object obj, Class destType) {
		List list = map(mapper, Arrays.asList(obj), destType);
		if (list != null) {
			return list.get(0);
		}
		return null;
	}

}
