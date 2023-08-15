package com.travelapp.form;

import com.travelapp.entity.Order;
import com.travelapp.entity.Ticket;
import com.travelapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateForm{
    @NotNull(message = "{PaymentForm.user.NotNull}")
    private User user;
    @NotNull(message = "{PaymentForm.ticket.NotNull}")
    private Ticket ticket;
    @NotNull(message = "{OrderForm.createDate.NotNull}")
    private LocalDateTime createDate;
    @NotNull(message = "{OrderForm.quantity.NotNull}")
    private Integer quantity;
    @NotNull(message = "{OrderForm.orderStatus.NotNull}")
    private Order.OrderStatus orderStatus;
}
