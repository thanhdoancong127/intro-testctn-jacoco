package com.intro.testcontainers.api;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.intro.testcontainers.base.BaseIntegrationTest;
import com.intro.testcontainers.entity.User;
import com.intro.testcontainers.repository.UserRepository;
import com.intro.testcontainers.viewmodel.UserVm;

public class UserPutCommandTest extends BaseIntegrationTest {
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
    void shouldPutUserSuccess() {
        UserVm uservVm = new UserVm(1l, "Robin", "robinIsOffline@gmail.com", "Hello Dragon!");
        testRestTemplate.put("/api/v1/user/1", uservVm);
        ResponseEntity<UserVm> response = testRestTemplate.getForEntity("/api/v1/user/1", UserVm.class);

        assertTrue(uservVm.email().equals(response.getBody().email()));
    }
}
