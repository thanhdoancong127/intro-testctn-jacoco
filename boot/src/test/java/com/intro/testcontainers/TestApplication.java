package com.intro.testcontainers;

import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestApplication {

	// @Bean
    // @Container
	// @ServiceConnection
	// PostgreSQLContainer<?> postgresContainer() {
	// 	return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16.2"));
	// }

    // public static void main(String[] args) {
    //     SpringApplication.from(Application::main).with(TestApplication.class).run(args);
    // }
}
