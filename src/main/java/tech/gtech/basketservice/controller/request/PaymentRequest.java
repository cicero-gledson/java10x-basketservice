package tech.gtech.basketservice.controller.request;

import tech.gtech.basketservice.entity.PaymentMethod;

public record PaymentRequest(PaymentMethod paymentMethod) {
}
