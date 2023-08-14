package com.travelapp.specification;

import com.travelapp.entity.Tour;
import com.travelapp.entity.abstractEntity.Tour_;
import com.travelapp.form.TourFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public class TourSpecification {
    public static Specification<Tour> buildWhere(TourFilterForm tourFilterForm) {
        if (tourFilterForm == null) {
            return null;
        }
        return hasNameLike(tourFilterForm.getSearch())
                .and(priceInRange(tourFilterForm.getMinPrice(), tourFilterForm.getMaxPrice()))
                .and(hasDestinationLike(tourFilterForm.getDestination()))
                .and(hasStartDateGreaterThanOrEqualTo(tourFilterForm.getStartDate()))
                .and(hasEndDateLessThanOrEqualTo(tourFilterForm.getEndDate()));
    }

    public static Specification<Tour> priceInRange(double minPrice, double maxPrice) {
        return (root, query, builder) ->
                builder.and(
                        builder.greaterThanOrEqualTo(root.get("price"), minPrice),
                        builder.lessThanOrEqualTo(root.get("price"), maxPrice)
                );
    }

    private static Specification<Tour> hasNameLike(String search) {
        return ((root, query, builder) -> {
            if (!StringUtils.hasText(search)) {
                return null;
            }
            return builder.like(root.get(Tour_.tourName), "%" + search.trim() + "%");
        });
    }

    private static Specification<Tour> hasDestinationLike(String destination) {
        return ((root, query, builder) -> {
            if (!StringUtils.hasText(destination)) {
                return null;
            }
            return builder.like(root.get(Tour_.destination), "%" + destination.trim() + "%");
        });
    }

    private static Specification<Tour> hasStartDateGreaterThanOrEqualTo(LocalDate startDate) {
        return (root, query, builder) -> {
            if (startDate == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get(Tour_.startDate).as(LocalDate.class), startDate);
        };
    }

    private static Specification<Tour> hasEndDateLessThanOrEqualTo(LocalDate endDate) {
        return (root, query, builder) -> {
            if (endDate == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get(Tour_.endDate).as(LocalDate.class), endDate);
        };
    }
}
