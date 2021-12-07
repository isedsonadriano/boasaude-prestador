package br.com.boasaude.cadastro.prestador.integration.dto;

import java.util.ArrayList;
import java.util.List;

public class PrestadoresDTO {
	
	private List<PrestadorDTO> prestadores;

	public List<PrestadorDTO> getPrestadores() {
		if (prestadores == null) {
			prestadores = new ArrayList<PrestadorDTO>();
		}
		return prestadores;
	}

	public void setAssociados(List<PrestadorDTO> prestadores) {
		this.prestadores = prestadores;
	}
}
