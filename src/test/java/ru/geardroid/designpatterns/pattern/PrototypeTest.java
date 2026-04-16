package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.entity.pc.ARMProcessor;
import ru.geardroid.designpatterns.entity.pc.PersonalComputer;
import ru.geardroid.designpatterns.entity.pc.Processor;
import ru.geardroid.designpatterns.entity.pc.X86Processor;

import static org.assertj.core.api.Assertions.assertThat;

class PrototypeTest {

    private static final Processor OLD_PROCESSOR = new ARMProcessor();
    private static final Processor NEW_PROCESSOR = new X86Processor();
    private static final PersonalComputer TEST_COMPUTER = new PersonalComputer(OLD_PROCESSOR);

    @Test
    void whenCopyComputer_thenCorrectProcessor() {
        // when:
        var newComputer = TEST_COMPUTER
                .copy();
        // then:
        assertThat(newComputer.getProcessor())
                .isEqualTo(TEST_COMPUTER.getProcessor());
    }

    @Test
    void givenCopiedComputer_whenSetProcessor_thenNewProcessor() {
        // given:
        var newComputer = TEST_COMPUTER
                .copy();
        // when:
        newComputer.setProcessor(NEW_PROCESSOR);
        // then:
        assertThat(newComputer.getProcessor())
                .isEqualTo(NEW_PROCESSOR);
    }
}
