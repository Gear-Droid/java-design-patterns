package ru.geardroid.design_patterns.pattern;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import ru.geardroid.design_patterns.entity.user.User;
import ru.geardroid.design_patterns.pattern.mediator.MessageMediator;

import static org.mockito.Mockito.*;

public class MediatorTest {

    private static final User TEST_USER = new User("testUser");
    private static final String TEST_MESSAGE = "testMessage";

    private final MockedStatic<MessageMediator> mockStaticMessageMediator = Mockito.mockStatic(MessageMediator.class);

    @Test
    void givenStaticMessageMediatorMock_whenSendMessage_thenVerifyCalledOneTimeSuccessfully() {
        // given:
        try (mockStaticMessageMediator) {
            // when:
            TEST_USER.sendMessage(TEST_MESSAGE);
            // then:
            mockStaticMessageMediator.verify(
                    () -> MessageMediator.sendMessage(TEST_USER, TEST_MESSAGE),
                    times(1)
            );
        }
    }
}
