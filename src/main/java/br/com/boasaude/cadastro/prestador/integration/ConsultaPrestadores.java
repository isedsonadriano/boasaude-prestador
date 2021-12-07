package br.com.boasaude.cadastro.prestador.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.boasaude.cadastro.prestador.integration.dto.PrestadoresDTO;

@FeignClient(name = "ConsultaPrestadores", url = "${api.external.middleware.sgps.prestadores}")
public interface ConsultaPrestadores {

	@GetMapping()
	PrestadoresDTO consulta();
}
