package com.travelapp.specification;

import com.travelapp.entity.User;
import com.travelapp.entity.abstractEntity.User_;
import com.travelapp.form.UserFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class UserSpecification {
    public static Specification<User> buildWhere(UserFilterForm form) {
        if (form == null) {
            return null;
        }
        return hasUsernameLike(form.getSearch())
                .or(hasFirstNameLike(form.getSearch()))
                .or(hasLastNameLike(form.getSearch()))
                .and(hasRoleEqual(form.getRole()))
                .and(hasIdGreaterThanOrEqualTo(form.getMinId()))
                .and(hasIdLessThanOrEqualTo(form.getMaxId()));
    }

    public static Specification<User> hasUsernameLike(String value) {
        return (root, query, builder) -> {
            if (!StringUtils.hasText(value)) {
                return null;
            }
            return builder.like(root.get(User_.userName), "%" + value.trim() + "%");
        };
    }

    public static Specification<User> hasFirstNameLike(String value) {
        return (root, query, builder) -> {
            if (!StringUtils.hasText(value)) {
                return null;
            }
            return builder.like(root.get(User_.firstName), "%" + value.trim() + "%");
        };
    }

    public static Specification<User> hasLastNameLike(String value) {
        return (root, query, builder) -> {
            if (!StringUtils.hasText(value)) {
                return null;
            }
            return builder.like(root.get(User_.lastName), "%" + value.trim() + "%");
        };
    }

    public static Specification<User> hasRoleEqual(User.Role role) {
        return (root, query, builder) -> {
            if (role == null) {
                return null;
            }
            return builder.equal(root.get(User_.role), role);
        };
    }

    public static Specification<User> hasIdGreaterThanOrEqualTo(Integer minId) {
        return (root, query, builder) -> {
            if (minId == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get(User_.id), minId);
        };
    }

    public static Specification<User> hasIdLessThanOrEqualTo(Integer maxId) {
        return (root, query, builder) -> {
            if (maxId == null) {
                return null;
            }
            return builder.lessThanOrEqualTo(root.get(User_.id), maxId);
        };
    }
}
