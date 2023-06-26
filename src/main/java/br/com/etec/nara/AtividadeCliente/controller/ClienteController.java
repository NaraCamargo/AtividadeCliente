package br.com.etec.nara.AtividadeCliente.controller;

import br.com.etec.nara.AtividadeCliente.model.Cliente;
import br.com.etec.nara.AtividadeCliente.repository.ClienteRepository;
import br.com.etec.nara.AtividadeCliente.repository.filter.ClienteFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienterepository;

    @GetMapping()
    public Page<Cliente> pesquisar(ClienteFilter cursoFilter, Pageable pageable){
        return clienterepository.Filtrar(cursoFilter, pageable);
    }

    @GetMapping("/todos")
    public List<Cliente> listarTodosClientes() {
        return clienterepository.findAll();
    }


}
