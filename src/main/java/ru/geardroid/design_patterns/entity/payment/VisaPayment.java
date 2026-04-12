package ru.geardroid.design_patterns.entity.payment;

import lombok.Setter;
import ru.geardroid.design_patterns.pattern.chain_of_responsibility.PaymentChainOfResponsibility;

public class VisaPayment implements PaymentChainOfResponsibility {

    private Payment payment;
    @Setter
    private boolean isActive = true;

    @Override
    public void setNext(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void pay() {
        if (isActive) {
            System.out.println("Visa Payment");
        } else {
            payment.pay();
        }
    }
}
