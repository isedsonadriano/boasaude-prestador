package br.com.boasaude.cadastro.prestador.core.service;

import java.util.List;

import br.com.boasaude.cadastro.prestador.core.domain.entity.Prestador;
import br.com.boasaude.cadastro.prestador.core.util.Paginador;

public interface PrestadorService {

	public List<Prestador> capturarTodos(Paginador paginador);

	public Prestador capturarPorId(Long id);

	public void salvar(Prestador prestador);

	public void atualizar(Prestador prestador);

	public void deletar(Long id);

}
