package com.nagarro.jenkins;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JenkinsApplicationTests {

	@Test
	void contextLoads() {
		assertThat(true).isTrue();
	}

	@Test
	void demoTest() {
		assertThat("Bharath").isEqualTo("Bharath");
	}

	@Test
	void nagarroTest() {
		assertThat("Nagarro")
				.startsWith("N").endsWith("o");
	}
}
