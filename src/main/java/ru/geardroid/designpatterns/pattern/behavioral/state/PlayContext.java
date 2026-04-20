package ru.geardroid.designpatterns.pattern.behavioral.state;

import lombok.Getter;
import lombok.Setter;
import ru.geardroid.designpatterns.entity.player.StartPlay;

public class PlayContext implements PlayerState {

    @Setter
    private PlayerState state;
    @Getter
    private boolean isPlaying;

    public void doAction() {
        isPlaying = state instanceof StartPlay;
        this.state.doAction();
    }
}
