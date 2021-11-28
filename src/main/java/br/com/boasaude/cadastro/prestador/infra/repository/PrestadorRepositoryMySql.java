package br.com.boasaude.cadastro.prestador.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.boasaude.cadastro.prestador.infra.repository.orm.PrestadorJpa;

@Repository
public interface PrestadorRepositoryMySql extends JpaRepository<PrestadorJpa, Long> {

	PrestadorJpa findByCpf(String cpf);


}
