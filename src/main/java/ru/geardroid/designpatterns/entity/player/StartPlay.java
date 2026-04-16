package ru.geardroid.designpatterns.entity.player;

import ru.geardroid.designpatterns.pattern.state.PlayerState;

public class StartPlay implements PlayerState {

    @Override
    public void doAction() {
        System.out.println("start play");
    }
}
