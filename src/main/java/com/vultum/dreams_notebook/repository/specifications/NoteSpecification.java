package com.vultum.dreams_notebook.repository.specifications;

import com.vultum.dreams_notebook.dto.filter.Filter;
import com.vultum.dreams_notebook.entity.Note;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public abstract class NoteSpecification implements Specification<Note> {

    public static NoteSpecification build(Filter filter) {
        return new NoteSpecification() {
            @Override
            public Predicate toPredicate(Root<Note> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
                final List<Predicate> predicates = new ArrayList<>();

                if (filter != null) {
                    if (filter.getSearch() != null && !filter.getSearch().isEmpty()) {
                        predicates.add(cb.or(
                                cb.like(cb.upper(r.get("title")), "%" + filter.getSearch().toUpperCase() + "%"),
                                cb.like(cb.upper(r.get("text")), "%" + filter.getSearch().toUpperCase() + "%")
                        ));
                    }

                    // todo ordering
                }

                return cb.and((Predicate[]) predicates.toArray());
            }
        };
    }


}
