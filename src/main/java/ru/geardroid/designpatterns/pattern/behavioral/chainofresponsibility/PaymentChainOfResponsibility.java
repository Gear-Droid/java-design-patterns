package ru.geardroid.designpatterns.pattern.behavioral.chainofresponsibility;

import ru.geardroid.designpatterns.entity.payment.Payment;

public interface PaymentChainOfResponsibility extends Payment {

    void setNext(Payment payment);
}
