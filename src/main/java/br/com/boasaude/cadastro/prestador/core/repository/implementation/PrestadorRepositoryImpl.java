package br.com.boasaude.cadastro.prestador.core.repository.implementation;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import br.com.boasaude.cadastro.prestador.application.prestador.mapper.PrestadorMapper;
import br.com.boasaude.cadastro.prestador.core.domain.entity.Prestador;
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
		return PrestadorMapper.prestadorJpaToPrestador(prestadorJpa);
	}

	@Override
	public List<Prestador> capturarTodos(Paginador paginador) {
		return capturarPrestadoresBD(paginador);
	}

	private List<Prestador> capturarPrestadoresBD(Paginador paginador) {
		PageRequest paginaRetorno =   PageRequest.of(paginador.getPageNumber(), paginador.getPageSize(), Sort.by("id").descending());
		return repository.findAll(paginaRetorno).get().map(this::buildPrestador).collect(Collectors.toList());
	}

	@Override
	public void atualizar(Prestador prestador) {
		Optional<PrestadorJpa> prestadorJpaOpt = this.repository.findById(prestador.getId());
		if (prestadorJpaOpt.isPresent()) {
			PrestadorJpa prestadorJpa = prestadorJpaOpt.get();
			prestadorJpa.setCpf(prestador.getCpf());
			prestadorJpa.setNome(prestador.getNome());
			prestadorJpa.setTipo(prestador.getTipo());
			prestadorJpa.setCbos(prestador.getCbos());
			prestadorJpa.setCnes(prestador.getCnes());
			prestadorJpa.setConselho(prestador.getConselho());
			prestadorJpa.setNumeroNoConselho(prestador.getNumeroNoConselho());
			prestadorJpa.setStatus(prestador.getStatus());
			prestadorJpa.setTelefone(prestador.getTelefone());
			
			this.repository.save(prestadorJpa);
		}
		
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
		prestador.setId(prestadorJpa.getId());
		prestador.setNome(prestadorJpa.getNome());
		prestador.setCpf(prestadorJpa.getCpf());
		prestador.setTipo(prestadorJpa.getTipo());
		return prestador;
	}

	private PrestadorJpa buildPrestadorJpa(Prestador prestador) {
		return PrestadorMapper.prestadorToPrestadorJpa(prestador);
	}

	@Override
	public Prestador findByCpf(String cpf) {
		PrestadorJpa prestadorJpa = this.repository.findByCpf(cpf);
		return buildPrestador(prestadorJpa);
	}
}
