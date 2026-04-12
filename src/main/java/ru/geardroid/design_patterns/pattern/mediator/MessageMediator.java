package ru.geardroid.design_patterns.pattern.mediator;

import ru.geardroid.design_patterns.entity.user.User;

public class MessageMediator {

    public static void sendMessage(User user, String msg) {
        System.out.println(user.name() + ": " + msg);
    }
}
