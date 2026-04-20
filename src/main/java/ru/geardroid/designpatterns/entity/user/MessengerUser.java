package ru.geardroid.designpatterns.entity.user;

import ru.geardroid.designpatterns.pattern.mediator.MessageMediator;

public record MessengerUser(String name) {

    public void sendMessage(String msg) {
        MessageMediator.sendMessage(this, msg);
    }
}
