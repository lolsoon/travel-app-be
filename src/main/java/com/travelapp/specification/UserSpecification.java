package com.travelapp.specification;

import com.travelapp.entity.User;
import com.travelapp.entity.abstractEntity.User_;
import com.travelapp.form.UserFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.Set;

public class UserSpecification {
    public static Specification<User> buildWhere(UserFilterForm userFilterForm) {
        if (userFilterForm == null) {
            return null;
        }
        return hasUsernameLike(userFilterForm.getSearch())
                .or(hasFirstNameLike(userFilterForm.getSearch()))
                .or(hasLastNameLike(userFilterForm.getSearch()))
                .and(hasRoleEqual(userFilterForm.getUserRole()))
                .and(hasIdGreaterThanOrEqualTo(userFilterForm.getMinId()))
                .and(hasIdLessThanOrEqualTo(userFilterForm.getMaxId()));
//                .and(hasCardIdLike(userFilterForm.getCardId()));
    }

//    private static Specification<User> hasCardIdLike(String cardId) {
//        return (root, query, builder) -> {
//            if (!StringUtils.hasText(cardId)) {
//                return null;
//            }
//            return builder.like(root.get(User_.cardId), "%" + cardId.trim() + "%");
//        };
//    }

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

    public static Specification<User> hasRoleEqual(User.UserRole userRole) {
        return (root, query, builder) -> {
            if (userRole == null) {
                return null;
            }
            return builder.equal(root.get(User_.role), userRole);
        };
    }

    public static Specification<User> hasIdGreaterThanOrEqualTo(Integer minId) {
        return (root, query, builder) -> {
            if (minId == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get(User_.userId), minId);
        };
    }

    public static Specification<User> hasIdLessThanOrEqualTo(Integer maxId) {
        return (root, query, builder) -> {
            if (maxId == null) {
                return null;
            }
            return builder.lessThanOrEqualTo(root.get(User_.userId), maxId);
        };
    }
    private static Specification<User> searchByRole(Set<User.UserRole> userRole) {
        if (userRole != null) {
            return ((root, query, criteriaBuilder) -> {
                return criteriaBuilder.equal(root.get("role"), userRole);
            });
        } else {
            return null;
        }
    }

    private static Specification<User> searchByEmail(String email) {
        if (email != null) {
            return ((root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("email"), "%" + email + "%");
            });
        } else {
            return null;
        }
    }
    private static Specification<User> searchByPhone(String phoneNumber) {
        if (phoneNumber != null) {
            return ((root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("phone"), "%" + phoneNumber + "%");
            });
        } else {
            return null;
        }
    }
}
