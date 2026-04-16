package ru.geardroid.designpatterns.pattern.mediator;

import ru.geardroid.designpatterns.entity.user.User;

public class MessageMediator {

    public static void sendMessage(User user, String msg) {
        System.out.println(user.name() + ": " + msg);
    }
}
