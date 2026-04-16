package ru.geardroid.designpatterns.entity.payment;

import lombok.Getter;
import ru.geardroid.designpatterns.pattern.chainofresponsibility.PaymentChainOfResponsibility;

@Getter
public class PayPalPayment implements PaymentChainOfResponsibility {

    private Payment payment;

    @Override
    public void setNext(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void pay() {
        System.out.println("PayPal Payment");
    }
}
