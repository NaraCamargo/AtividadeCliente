package br.com.etec.nara.AtividadeCliente.repository;

import br.com.etec.nara.AtividadeCliente.model.ContasReceber;
import br.com.etec.nara.AtividadeCliente.repository.contasreceber.ContasReceberRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasReceberRepository extends JpaRepository<ContasReceber, Integer>, ContasReceberRepositoryQuery {

}
