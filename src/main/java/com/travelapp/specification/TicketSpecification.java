package com.travelapp.specification;

import com.travelapp.entity.*;
import com.travelapp.entity.abstractEntity.Ticket_;
import com.travelapp.form.TicketFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Set;

public class TicketSpecification {
    public static Specification<Ticket> buildWhere(TicketFilterForm ticketFilterForm) {
        if (ticketFilterForm == null) {
            return null;
        }
        return searchByUser(ticketFilterForm.getUsers())
                .and(searchByflight(ticketFilterForm.getFlight()))
                .and(searchByHotel(ticketFilterForm.getHotel()))
                .and(hasDepartureLocationLike(ticketFilterForm.getDepartureLocation()))
                .and(hasDestinationLike(ticketFilterForm.getDestination()))
                .and(hasDepartureDate(ticketFilterForm.getDepartureDate()))
                .and(hasPriceInRange(ticketFilterForm.getMinPrice(), ticketFilterForm.getMaxPrice()))
                .and(searchByQuantity(ticketFilterForm.getQuantity()))
                ;
    }

    public static Specification<Ticket> searchByUser(Set<User> users) {
        return ((root, query, builder) -> {
            if (users == null) {
                return null;
            }
            return builder.like(root.get("users"), "%" + users + "%");
        });
    }

    //    public static Specification<Ticket> searhByFlight(Flight flight) {
//        return ((root, criteriaQuery, criteriaBuilder) -> {
//            if ((flight))
//        });
//    }
    private static Specification<Ticket> searchByflight(Set<Flight> flight) {
        if (flight != null) {
            return ((root, query, criteriaBuilder) -> {
                return criteriaBuilder.equal(root.get("flight"), flight);
            });
        } else {
            return null;
        }
    }
    private static Specification<Ticket> searchByHotel(Set<Hotel> hotel) {
        if (hotel != null) {
            return ((root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("hotel"), "%" + hotel + "%");
            });
        } else {
            return null;
        }
    }
    private static Specification<Ticket> hasDepartureLocationLike(String departureLocation) {
        return ((root, query, builder) -> {
            if (!StringUtils.hasText(departureLocation)) {
                return null;
            }
            return builder.like(root.get(Ticket_.DEPARTURELOCATION), "%" + departureLocation.trim() + "%");
        });
    }
    private static Specification<Ticket> hasDestinationLike(String destination) {
        return ((root, query, builder) -> {
            if (!StringUtils.hasText(destination)) {
                return null;
            }
            return builder.like(root.get(Ticket_.destination), "%" + destination.trim() + "%");
        });
    }

    private static Specification<Ticket> hasDepartureDate(LocalDateTime departureDate) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
           if (departureDate ==  null) {
               return null;
           }
            return criteriaBuilder.like(root.get("departureDate"), "%" + departureDate + "%");
        });
    };

    public static Specification<Ticket> hasPriceInRange(double minPrice, double maxPrice) {
        return (root, query, builder) ->
                builder.and(
                        builder.greaterThanOrEqualTo(root.get("price"), minPrice),
                        builder.lessThanOrEqualTo(root.get("price"), maxPrice)
                );
    }

    private static Specification<Ticket> searchByQuantity(Integer quantity) {
        if (quantity != null) {
            return ((root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("quantity"), "%" + quantity + "%");
            });
        } else {
            return null;
        }
    }
}
