package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;
import ru.geardroid.designpatterns.entity.pc.ARMProcessor;
import ru.geardroid.designpatterns.entity.pc.Processor;
import ru.geardroid.designpatterns.entity.pc.X86Processor;
import ru.geardroid.designpatterns.pattern.creational.builder.ARMPCBuilder;
import ru.geardroid.designpatterns.pattern.creational.builder.PCBuilder;
import ru.geardroid.designpatterns.pattern.creational.builder.X86PCBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BuilderTest {

    private static final List<Arguments> PC_TEST_DATA = List.of(
            Arguments.of(new X86PCBuilder(), new X86Processor()),
            Arguments.of(new ARMPCBuilder(), new ARMProcessor())
    );

    @ParameterizedTest
    @FieldSource("PC_TEST_DATA")
    void whenBuildPC_thenCorrectProcessor(PCBuilder builder, Processor expectedProcessor) {
        // when:
        var processor = builder.build()
                .getProcessor();
        // then:
        assertThat(processor.getProcessorType())
                .isEqualTo(expectedProcessor.getProcessorType());
    }
}
