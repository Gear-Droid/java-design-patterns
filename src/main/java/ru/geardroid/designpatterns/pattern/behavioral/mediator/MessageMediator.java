package ru.geardroid.designpatterns.pattern.behavioral.mediator;

import ru.geardroid.designpatterns.entity.user.MessengerUser;

public class MessageMediator {

    public static void sendMessage(MessengerUser user, String msg) {
        System.out.println(user.name() + ": " + msg);
    }
}
