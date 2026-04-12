package ru.geardroid.design_patterns.entity.user;

import ru.geardroid.design_patterns.pattern.mediator.MessageMediator;

public record User(String name) {

    public void sendMessage(String msg) {
        MessageMediator.sendMessage(this, msg);
    }
}
