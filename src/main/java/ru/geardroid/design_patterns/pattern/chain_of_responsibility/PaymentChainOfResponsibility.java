package ru.geardroid.design_patterns.pattern.chain_of_responsibility;

import ru.geardroid.design_patterns.entity.payment.Payment;

public interface PaymentChainOfResponsibility extends Payment {

    void setNext(Payment payment);
}
