package br.com.etec.nara.AtividadeCliente.repository.contasreceber;

import br.com.etec.nara.AtividadeCliente.repository.Dtos.ContasReceberDtos;
import br.com.etec.nara.AtividadeCliente.repository.filter.ContasReceberFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContasReceberRepositoryQuery{

    public Page<ContasReceberDtos> filtrar(ContasReceberFilter contasreceberfilter, Pageable pageable);
}
