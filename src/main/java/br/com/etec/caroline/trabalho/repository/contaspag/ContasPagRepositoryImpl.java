package br.com.etec.caroline.trabalho.repository.contaspag;

import br.com.etec.caroline.trabalho.model.ContasPag;
import br.com.etec.caroline.trabalho.repository.filter.ContasPagFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
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
    public Page<ContasPag> filtrar(ContasPagFilter contasPagFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ContasPag> criteria = builder.createQuery(ContasPag.class);
        Root<ContasPag> root = criteria.from(ContasPag.class);

        Predicate[] predicates = criarRestricoes(contasPagFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("dataPag")));

        TypedQuery<ContasPag> query = manager.createQuery(criteria);

        return null;
    }

    private Predicate[] criarRestricoes(ContasPagFilter contasPagFilter, CriteriaBuilder builder, Root<ContasPag> root) {
        List<Predicate> predicates = new ArrayList<>();

    }
}
