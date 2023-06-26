package br.com.etec.nara.AtividadeCliente.repository.cliente;

import br.com.etec.nara.AtividadeCliente.model.Cliente;
import br.com.etec.nara.AtividadeCliente.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
    public Page<Cliente> Filtrar(ClienteFilter clienteFilter, Pageable pageable);
}
