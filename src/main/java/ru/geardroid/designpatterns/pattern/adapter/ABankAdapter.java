package ru.geardroid.designpatterns.pattern.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.geardroid.designpatterns.entity.bank.ABank;
import ru.geardroid.designpatterns.entity.bank.TBank;

@Getter
@Setter
@AllArgsConstructor
public class ABankAdapter extends ABank {

    private int taCurrency;
    private TBank bank;

    @Override
    public int getBalance() {
        return bank.getBalance() * taCurrency;
    }
}
