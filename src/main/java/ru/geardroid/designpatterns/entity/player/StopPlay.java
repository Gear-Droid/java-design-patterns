package ru.geardroid.designpatterns.entity.player;

import ru.geardroid.designpatterns.pattern.behavioral.state.PlayerState;

public class StopPlay implements PlayerState {

    @Override
    public void doAction() {
        System.out.println("stop play");
    }
}
