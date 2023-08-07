package com.travelapp.validation.anotation;

import javax.validation.Payload;

public @interface OrderExistsById {
    String message() default "Đơn hàng không tồn tại";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
