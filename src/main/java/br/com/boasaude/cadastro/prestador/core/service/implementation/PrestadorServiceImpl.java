package br.com.boasaude.cadastro.prestador.core.service.implementation;

import br.com.boasaude.cadastro.prestador.core.domain.entity.Prestador;
import br.com.boasaude.cadastro.prestador.core.exception.DomainException;
import br.com.boasaude.cadastro.prestador.core.repository.PrestadorRepository;
import br.com.boasaude.cadastro.prestador.core.service.PrestadorService;
import br.com.boasaude.cadastro.prestador.core.util.Paginador;

import java.util.List;
import java.util.Objects;

public class PrestadorServiceImpl implements PrestadorService {

	final private PrestadorRepository clientRepository;

	public PrestadorServiceImpl(PrestadorRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public List<Prestador> capturarTodos(Paginador paginador) {
		return clientRepository.capturarTodos(paginador);
	}

	@Override
	public Prestador capturarPorId(Long id) {
		return clientRepository.capturarPorId(id);
	}

	@Override
	public void salvar(Prestador prestador) {
		DomainException.throwIf(Objects.nonNull(this.clientRepository.findByCpf(prestador.getCpf())), "Prestador já cadastrado");
		this.clientRepository.salvar(prestador);
	}

	@Override
	public void atualizar(Prestador prestador) {
		this.clientRepository.atualizar(prestador);
	}

	@Override
	public void deletar(Long id) {
		this.clientRepository.deletar(id);
	}
}
