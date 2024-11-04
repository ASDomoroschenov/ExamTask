package ru.sberp.javaseniortask.utils;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import ru.sberp.javaseniortask.dto.request.user.UserSearchFilter;
import ru.sberp.javaseniortask.models.EmailData;
import ru.sberp.javaseniortask.models.PhoneData;
import ru.sberp.javaseniortask.models.User;

@UtilityClass
public class UserSpecifications {

  public Specification<User> withFilters(UserSearchFilter filter) {
    return (root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (filter.getName() != null) {
        predicates.add(criteriaBuilder.equal(root.get("name"), filter.getName()));
      }

      if (filter.getDateOfBirth() != null) {
        predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dateOfBirth"), filter.getDateOfBirth()));
      }

      if (filter.getPhone() != null) {
        Join<User, PhoneData> phoneJoin = root.join("phones");
        predicates.add(
            criteriaBuilder.equal(phoneJoin.get("phone"), filter.getPhone()));
      }

      if (filter.getEmail() != null) {
        Join<User, EmailData> emailJoin = root.join("emails");
        predicates.add(criteriaBuilder.equal(emailJoin.get("email"), filter.getEmail()));
      }

      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
  }
}
