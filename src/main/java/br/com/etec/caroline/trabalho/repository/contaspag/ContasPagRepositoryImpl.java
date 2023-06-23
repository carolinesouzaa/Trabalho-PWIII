package br.com.etec.caroline.trabalho.repository.contaspag;

import br.com.etec.caroline.trabalho.model.ContasPag;
import br.com.etec.caroline.trabalho.repository.filter.ContasPagFilter;
import br.com.etec.caroline.trabalho.repository.projections.ResumoContas;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
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

public class ContasPagRepositoryImpl implements ContasPagRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public Page<ResumoContas> filtrar(ContasPagFilter contasPagFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ResumoContas> criteria = builder.createQuery(ResumoContas.class);
        Root<ContasPag> root = criteria.from(ContasPag.class);

        criteria.select(builder.construct(ResumoContas.class
                ,root.get("id")
                ,root.get("data")
                ,root.get("cliente").get("nomecliente")
        ));

        Predicate[] predicates = criarRestricoes(contasPagFilter , builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomefilme")));

        TypedQuery<ResumoContas> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(contasPagFilter));
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistroPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistroPorPagina);
    }

    private Long total(ContasPagFilter contasPagFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<ContasPag> root = criteria.from(ContasPag.class);

        Predicate[] predicates = criarRestricoes(contasPagFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("data")));

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }

    private Predicate[] criarRestricoes(ContasPagFilter contasPagFilter, CriteriaBuilder builder, Root<ContasPag> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (contasPagFilter.getDatapag() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("datapag"), contasPagFilter.getDatapag()));
        }

        if (contasPagFilter.getDatapag() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("datapag"), contasPagFilter.getDatapag()));
        }

        return predicates.toArray((new  Predicate[predicates.size()]));

    }
}
