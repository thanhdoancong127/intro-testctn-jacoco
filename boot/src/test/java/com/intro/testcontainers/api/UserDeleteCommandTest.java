package com.intro.testcontainers.api;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intro.testcontainers.base.BaseIntegrationTest;
import com.intro.testcontainers.entity.User;
import com.intro.testcontainers.repository.UserRepository;

public class UserDeleteCommandTest extends BaseIntegrationTest {

    private List<User> users = List.of(
        new User("Robin", "robinIsOnline@gmail.com", "Hello Dragon!"),
        new User("Batman", "batmanIsOnline@gmail.com", "Hello Robin!")
    );

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.saveAll(users);
    }

    @Test
    void shouldDeleteUserSuccess() {
        assertTrue(userRepository.findAll().size() > 0);
        testRestTemplate.delete("/api/v1/user");
        assertTrue(userRepository.count() == 0);
    }
}
