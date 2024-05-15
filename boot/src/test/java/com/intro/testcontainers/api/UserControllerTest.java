package com.intro.testcontainers.api;

import com.intro.testcontainers.base.BaseIntegrationTest;
import com.intro.testcontainers.viewmodel.UserVm;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

public class UserControllerTest extends BaseIntegrationTest {

    @Test
    void shouldCreateUser() {
        // Given by using random mock
        UserVm userVm = new UserVm(Mockito.anyString(), "example@example.com", Mockito.anyString());

        ResponseEntity<UserVm> response = testRestTemplate.postForEntity( "/api/v1/user", userVm, UserVm.class);

        assertNotNull(response.getBody().id());
        assertTrue(userVm.equals(response.getBody()));
    }

    // @Test
    // void shouldGetUserAfterCreated() {
    //     // Given by using random mock
    //     UserVm userVm = new UserVm(Mockito.anyString(), "example@example.com", Mockito.anyString());

    //     ResponseEntity<UserVm> response = testRestTemplate.postForEntity( "/api/v1/user", userVm, UserVm.class);
    //     ResponseEntity<UserVm> responseGet = testRestTemplate.getForEntity( "/api/v1/user/" + response.getBody().id(), UserVm.class);

    //     assertNotNull(responseGet.getBody().id());
    //     assertTrue(userVm.equals(responseGet.getBody()));
    // }

    // @Test
    // void testGetFailUser() {
    //     // Given by using random mock
    //     UserVm userVm = new UserVm(Mockito.anyString(), "example@example.com", Mockito.anyString());

    //     ResponseEntity<UserVm> response = testRestTemplate.postForEntity( "/api/v1/user", userVm, UserVm.class);
    //     ResponseEntity<UserVm> responseGet = testRestTemplate.getForEntity( "/api/v1/user/" + response.getBody().id(), UserVm.class);

    //     assertNotNull(responseGet.getBody().id());
    //     assertTrue(userVm.equals(responseGet.getBody()));
    // }
}
