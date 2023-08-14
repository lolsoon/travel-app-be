package com.travelapp.specification;

import com.travelapp.entity.Booking;
import com.travelapp.form.BookingFilterForm;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingSpecification {

    public static Specification<Booking> filterBookings(BookingFilterForm filterForm) {
        return (Root<Booking> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filterForm.getSearch() != null && !filterForm.getSearch().isEmpty()) {
                String searchPattern = "%" + filterForm.getSearch() + "%";
                Predicate searchPredicate = criteriaBuilder.or(
                        criteriaBuilder.like(root.get("fullName"), searchPattern),
                        criteriaBuilder.like(root.get("email"), searchPattern)
                );
                predicates.add(searchPredicate);
            }

            if (filterForm.getUserId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("user").get("id"), filterForm.getUserId()));
            }

            if (filterForm.getBookingStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("bookingStatus"), filterForm.getBookingStatus()));
            }

            if (filterForm.getMinBookingDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("bookingDate"), filterForm.getMinBookingDate()));
            }

            if (filterForm.getMaxBookingDate() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("bookingDate"), filterForm.getMaxBookingDate()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
