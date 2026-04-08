package ru.geardroid.design_patterns.pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geardroid.design_patterns.entity.bank.ABank;
import ru.geardroid.design_patterns.entity.bank.TBank;
import ru.geardroid.design_patterns.pattern.adapter.ABankAdapter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AdapterTest {

    public static final int CURRENCY = 89;
    public static final int USD_BALANCE = 100;
    public static final int T_BANK_BALANCE = USD_BALANCE;
    public static final int A_BANK_BALANCE = CURRENCY * USD_BALANCE;

    private final TBank tBank = new TBank();
    private final ABank aBank = new ABank();

    @BeforeEach
    void setupBanks() {
        tBank.setBalance(T_BANK_BALANCE);
        aBank.setBalance(A_BANK_BALANCE);
    }

    @Test
    void whenAdapterGetBalance_thenEqualsWithCurrency(){
        // given:
        ABank adapter = new ABankAdapter(CURRENCY, tBank);
        // when:
        var aBankBalance = adapter.getBalance();
        // then:
        assertThat(aBankBalance).isEqualTo(aBank.getBalance());
    }
}
