package br.com.etec.nara.AtividadeCliente.controller;

import br.com.etec.nara.AtividadeCliente.model.ContasReceber;
import br.com.etec.nara.AtividadeCliente.repository.ContasReceberRepository;
import br.com.etec.nara.AtividadeCliente.repository.Dtos.ContasReceberDtos;
import br.com.etec.nara.AtividadeCliente.repository.filter.ContasReceberFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contasreceber")
public class ContasReceberController {

    @Autowired
    private ContasReceberRepository contasreceberrepository;

    @GetMapping()
    public Page<ContasReceberDtos> pesquisar(ContasReceberFilter contasreceberfilter, Pageable pageable){
        return contasreceberrepository.filtrar(contasreceberfilter, pageable);
    }

    @GetMapping("/todos")
    public List<ContasReceber> listartodascontasreceber() { return contasreceberrepository.findAll(); }
}
