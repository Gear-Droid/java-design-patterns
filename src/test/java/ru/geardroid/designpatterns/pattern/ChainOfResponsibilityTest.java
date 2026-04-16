package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.geardroid.designpatterns.entity.payment.PayPalPayment;
import ru.geardroid.designpatterns.entity.payment.Payment;
import ru.geardroid.designpatterns.entity.payment.VisaPayment;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ChainOfResponsibilityTest {

    private final Payment spiedPayPalPayment = Mockito.spy(new PayPalPayment());

    @Test
    void givenActiveVisaPayment_whenPay_thenPayPalNotUsed() {
        // given:
        VisaPayment visaPayment = new VisaPayment();
        visaPayment.setNext(spiedPayPalPayment);
        // when:
        visaPayment.pay();
        // then:
        verify(spiedPayPalPayment, times(0))
                .pay();
    }

    @Test
    void givenNotActiveVisaPayment_whenPay_thenPayPalSuccessPay() {
        // given:
        VisaPayment visaPayment = new VisaPayment();
        visaPayment.setActive(false);
        visaPayment.setNext(spiedPayPalPayment);
        // when:
        visaPayment.pay();
        // then:
        verify(spiedPayPalPayment, times(1))
                .pay();
    }
}
