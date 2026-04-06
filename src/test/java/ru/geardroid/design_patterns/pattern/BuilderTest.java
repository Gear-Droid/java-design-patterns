package ru.geardroid.design_patterns.pattern;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;
import ru.geardroid.design_patterns.entity.pc.ARMProcessor;
import ru.geardroid.design_patterns.entity.pc.Processor;
import ru.geardroid.design_patterns.entity.pc.X86Processor;
import ru.geardroid.design_patterns.pattern.builder.ARMPCBuilder;
import ru.geardroid.design_patterns.pattern.builder.PCBuilder;
import ru.geardroid.design_patterns.pattern.builder.X86PCBuilder;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BuilderTest {

    private static final List<Arguments> personalComputersTestData = List.of(
            Arguments.of(new X86PCBuilder(), new X86Processor()),
            Arguments.of(new ARMPCBuilder(), new ARMProcessor())
    );

    @ParameterizedTest
    @FieldSource("personalComputersTestData")
    void whenBuildPC_thenCorrectProcessor(PCBuilder builder, Processor expectedProcessor) {
        // when:
        var processor = builder.build()
                .processor();
        // then:
        assertThat(processor.getProcessorType())
                .isEqualTo(expectedProcessor.getProcessorType());
    }
}
