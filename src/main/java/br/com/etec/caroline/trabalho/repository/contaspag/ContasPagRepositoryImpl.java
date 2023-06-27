package br.com.etec.caroline.trabalho.repository.contaspag;

import br.com.etec.caroline.trabalho.model.ContasPag;
import br.com.etec.caroline.trabalho.repository.filter.ContasPagFilter;
import br.com.etec.caroline.trabalho.repository.projections.ResumoContas;
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

public class ContasPagRepositoryImpl implements ContasPagRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ResumoContas> filtrar(ContasPagFilter contasPagFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ResumoContas> criteria = builder.createQuery(ResumoContas.class);
        Root<ContasPag> root = criteria.from(ContasPag.class);

        criteria.select(builder.construct(ResumoContas.class,
                root.get("id"),
                root.get("datapag"),
                root.get("datavenc"),
                root.get("valor"),
                root.get("cliente").get("nome")));


        Predicate[] predicates = criarrestricoes(contasPagFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("datapag")));

        TypedQuery<ResumoContas> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(contasPagFilter));
    }

    private Long total(ContasPagFilter contasPagFilter){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<ContasPag> root = criteria.from(ContasPag.class);

        Predicate[] predicates = criarrestricoes(contasPagFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("datapag")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }


    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroPágina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroPágina);
        query.setMaxResults(totalRegistrosPorPagina);
    }


    private Predicate[] criarrestricoes(ContasPagFilter contasPagFilter, CriteriaBuilder builder, Root<ContasPag> root) {

        List<Predicate> predicates = new ArrayList<>();

        if(contasPagFilter.getDatapag() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("datapag"),
                    contasPagFilter.getDatapag()));
        }
        if(contasPagFilter.getDatapag() != null){
            predicates.add(builder.lessThanOrEqualTo(root.get("datapag"),
                    contasPagFilter.getDatapag()));
        }

        if(contasPagFilter.getDatavenc() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("datavenc"),
                    contasPagFilter.getDatavenc()));
        }
        if(contasPagFilter.getDatavenc() != null){
            predicates.add(builder.lessThanOrEqualTo(root.get("datavenc"),
                    contasPagFilter.getDatavenc()));
        }

        if (contasPagFilter.getValor() != null){
            predicates.add(builder.equal(root.get("valor"),
                    contasPagFilter.getValor()));
        }
        if(!StringUtils.isEmpty(contasPagFilter.getNome())){
            predicates.add(builder.like(builder.lower(root.get("cliente").get("nome")),
                    "%" + contasPagFilter.getNome() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
