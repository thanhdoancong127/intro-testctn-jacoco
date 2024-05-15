package com.intro.testcontainers.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.intro.testcontainers.base.BaseIntegrationTest;
import com.intro.testcontainers.viewmodel.UserVm;

public class UserGetCommandTest extends BaseIntegrationTest {

    @Test
    void shouldGetUserAfterCreated() {
        // Given by using random mock
        UserVm userVm = new UserVm(Mockito.anyString(), "example@example.com", Mockito.anyString());

        ResponseEntity<UserVm> response = testRestTemplate.postForEntity( "/api/v1/user", userVm, UserVm.class);
        ResponseEntity<UserVm> responseGet = testRestTemplate.getForEntity( "/api/v1/user/" + response.getBody().id(), UserVm.class);

        assertNotNull(responseGet.getBody().id());
        assertTrue(userVm.equals(responseGet.getBody()));
    }
}
