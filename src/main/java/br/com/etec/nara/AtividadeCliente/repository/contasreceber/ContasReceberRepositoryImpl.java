package br.com.etec.nara.AtividadeCliente.repository.contasreceber;

import br.com.etec.nara.AtividadeCliente.model.ContasReceber;
import br.com.etec.nara.AtividadeCliente.repository.Dtos.ContasReceberDtos;
import br.com.etec.nara.AtividadeCliente.repository.filter.ContasReceberFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ContasReceberRepositoryImpl implements ContasReceberRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ContasReceberDtos> filtrar(ContasReceberFilter contasreceberfilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ContasReceberDtos> criteria = builder.createQuery(ContasReceberDtos.class);
        Root<ContasReceber> root = criteria.from(ContasReceber.class);

        criteria.select(builder.construct(ContasReceberDtos.class,
                root.get("id"),
                root.get("dataconta"),
                root.get("valorconta"),
                root.get("cliente").get("nomecliente")));

        Predicate[] predicates = criarrestricoes(contasreceberfilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("valorconta")));

        TypedQuery<ContasReceberDtos> query = manager.createQuery(criteria);
        addrestricoespaginas(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(contasreceberfilter));

    }

    private Long total(ContasReceberFilter contasreceberfilter){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<ContasReceber> root = criteria.from(ContasReceber.class);

        Predicate[] predicates = criarrestricoes(contasreceberfilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("valorconta")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    private void addrestricoespaginas(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroPágina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroPágina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Predicate[] criarrestricoes(ContasReceberFilter contasreceberfilter, CriteriaBuilder builder, Root<ContasReceber> root) {

        List<Predicate> predicates = new ArrayList<>();

        if(contasreceberfilter.getValorconta() != null){
            predicates.add(builder.equal(root.get("valorconta"), contasreceberfilter.getValorconta()));
        }
        if(contasreceberfilter.getDataconta() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("dataconta"), contasreceberfilter.getDataconta()));
        }

        if (!StringUtils.isEmpty(contasreceberfilter.getNomecliente())){
            predicates.add(builder.like(builder.lower(root.get("cliente").get("nomecliente")),
                    "%" + contasreceberfilter.getNomecliente().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
