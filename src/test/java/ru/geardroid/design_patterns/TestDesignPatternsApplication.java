package ru.geardroid.design_patterns;

import org.springframework.boot.SpringApplication;

public class TestDesignPatternsApplication {

	static void main(String[] args) {
		SpringApplication.from(DesignPatternsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
