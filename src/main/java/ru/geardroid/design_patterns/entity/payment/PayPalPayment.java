package ru.geardroid.design_patterns.entity.payment;

import lombok.Getter;
import ru.geardroid.design_patterns.pattern.chain_of_responsibility.PaymentChainOfResponsibility;

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
