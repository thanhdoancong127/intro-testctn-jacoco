package com.intro.testcontainers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.intro.testcontainers.repository"})
public class SpringContextConfig {}
