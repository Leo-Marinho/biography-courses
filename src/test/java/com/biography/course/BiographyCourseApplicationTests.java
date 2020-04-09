package com.biography.course;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@SpringBootTest(classes = BiographyCourseApplication.class,
				webEnvironment = RANDOM_PORT)
@DirtiesContext( classMode = BEFORE_EACH_TEST_METHOD)
public class BiographyCourseApplicationTests {

	@LocalServerPort
	protected int port;

	@Test
	void contextLoads() {
	}

}
