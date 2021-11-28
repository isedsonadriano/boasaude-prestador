package br.com.boasaude.cadastro.prestador.core.repository.implementation;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import br.com.boasaude.cadastro.prestador.core.domain.entity.Prestador;
import br.com.boasaude.cadastro.prestador.core.domain.vo.TipoPrestador;
import br.com.boasaude.cadastro.prestador.core.repository.PrestadorRepository;
import br.com.boasaude.cadastro.prestador.core.util.Paginador;
import br.com.boasaude.cadastro.prestador.infra.repository.PrestadorRepositoryMySql;
import br.com.boasaude.cadastro.prestador.infra.repository.orm.PrestadorJpa;

public class PrestadorRepositoryImpl implements PrestadorRepository {

	private final PrestadorRepositoryMySql repository;

	public PrestadorRepositoryImpl(PrestadorRepositoryMySql repository) {
		this.repository = repository;
	}

	@Override
	public void salvar(Prestador prestador) {
		PrestadorJpa prestadorSalvo = repository.saveAndFlush(buildPrestadorJpa(prestador));
		prestador.setId(prestadorSalvo.getId());
	}

	@Override
	public Prestador capturarPorId(Long id) {
		PrestadorJpa prestadorJpa = repository.findById(id).get();
		Prestador prestador = new Prestador();
		prestador.setNome(prestadorJpa.getNome());
		prestador.setCnpj(prestadorJpa.getCnpj());
		prestador.setCpf(prestadorJpa.getCpf());
		prestador.setTipo(TipoPrestador.FISICA);
		return prestador;
	}

	@Override
	public List<Prestador> capturarTodos(Paginador paginador) {
		return capturarPrestadoresBD(paginador);
		//return capturarPrestadoresFaker(paginador);
	}

	private List<Prestador> capturarPrestadoresBD(Paginador paginador) {
		PageRequest paginaRetorno =   PageRequest.of(paginador.getPageNumber(), paginador.getPageSize(), Sort.by("id"));
		return repository.findAll(paginaRetorno).get().map(this::buildPrestador).collect(Collectors.toList());
	}

	@Override
	public void atualizar(Prestador prestador) {
		Optional<PrestadorJpa> prestadorJpa = this.repository.findById(prestador.getId());
		if (prestadorJpa.isPresent()) {
			prestadorJpa.get().setCnpj(prestador.getCnpj());
		}
		this.repository.save(prestadorJpa.get());
	}

	@Override
	public void deletar(Long id) {
		this.repository.deleteById(id);
	}

	private Prestador buildPrestador(PrestadorJpa prestadorJpa) {
		if(Objects.isNull(prestadorJpa)) {
			return null;
		}
		Prestador prestador = new Prestador();
		prestador.setNome(prestadorJpa.getNome());
		return prestador;
	}

	private PrestadorJpa buildPrestadorJpa(Prestador prestador) {
		PrestadorJpa prestadorJpa = new PrestadorJpa();
		prestadorJpa.setNome(prestador.getNome());
		prestadorJpa.setCnpj(prestador.getCnpj());
		prestadorJpa.setCpf(prestador.getCpf());
		prestadorJpa.setRazaoSocial(prestador.getRazaoSocial());
		prestadorJpa.setTipo(TipoPrestador.FISICA);
		return prestadorJpa;
	}

	@Override
	public Prestador findByCpf(String cpf) {
		PrestadorJpa prestadorJpa = this.repository.findByCpf(cpf);
		return buildPrestador(prestadorJpa);
	}
}
