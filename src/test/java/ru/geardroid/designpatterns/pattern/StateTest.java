package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.entity.player.StartPlay;
import ru.geardroid.designpatterns.entity.player.StopPlay;
import ru.geardroid.designpatterns.pattern.behavioral.state.PlayContext;
import ru.geardroid.designpatterns.pattern.behavioral.state.PlayerState;

import static org.assertj.core.api.Assertions.assertThat;

public class StateTest {

    @Test
    void givenStartPlayerState_whenExecute_thenPlaying() {
        // given:
        PlayerState playState = new StartPlay();
        var player = new PlayContext();
        // when:
        player.setState(playState);
        player.doAction();
        // then:
        assertThat(player.isPlaying()).isEqualTo(true);
    }

    @Test
    void givenStartAndStopPlayerState_whenExecute_thenNotPlaying() {
        // given:
        PlayerState startPlayState = new StartPlay();
        PlayerState stopPlayState = new StopPlay();
        var player = new PlayContext();
        // when:
        player.setState(startPlayState);
        player.doAction();
        player.setState(stopPlayState);
        player.doAction();
        // then:
        assertThat(player.isPlaying()).isEqualTo(false);
    }
}
