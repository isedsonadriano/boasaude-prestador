package br.com.boasaude.cadastro.prestador.core.repository;

import java.util.List;

import br.com.boasaude.cadastro.prestador.core.domain.entity.Prestador;
import br.com.boasaude.cadastro.prestador.core.util.Paginador;

public interface PrestadorRepository {

	void salvar(Prestador prestador);

	Prestador capturarPorId(Long id);

	List<Prestador> capturarTodos(Paginador paginador);

	void atualizar(Prestador prestador);

	void deletar(Long id);

	Prestador findByCpf(String cpf);

}
