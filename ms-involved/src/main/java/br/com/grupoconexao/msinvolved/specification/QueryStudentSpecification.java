package br.com.grupoconexao.msinvolved.specification;

import br.com.grupoconexao.msinvolved.dtos.QueryStudentFilterDTO;
import br.com.grupoconexao.msinvolved.entities.Student;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QueryStudentSpecification {

    private static final String EDUCATIONAL_INSTITUTION = "educationalInstitution";

    public static Specification<Student> findAll(QueryStudentFilterDTO filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            addPredicateEqualIfNotBlank(filter.getEducationalInstitution(), EDUCATIONAL_INSTITUTION, criteriaBuilder, root, predicates);

            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        };
    }

    private static void addPredicateEqualIfNotBlank(String value, String name, CriteriaBuilder cb, Root<Student> root, List<Predicate> predicates) {
        if (StringUtils.isNotBlank(value)) {
            predicates.add(cb.equal(root.get(name), value));
        }
    }
}
