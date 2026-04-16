package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.entity.player.StartPlay;
import ru.geardroid.designpatterns.pattern.state.PlayContext;
import ru.geardroid.designpatterns.pattern.state.PlayerState;

import static org.assertj.core.api.Assertions.assertThat;

public class StateTest {

    @Test
    void givenStartCarCommand_whenExecute_thenStartedFlag() {
        // given:
        PlayerState playState = new StartPlay();
        var player = new PlayContext();
        // when:
        player.setState(playState);
        player.doAction();
        // then:
        assertThat(player.isPlaying()).isEqualTo(true);
    }
}
