package com.intro.testcontainers.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import com.intro.testcontainers.viewmodel.UserVm;

public record User (
    @Id
    Long id,
    String name,
    String email,
    String body,
    @Version
    Integer version
) {
    public User(String name, String email, String body) {
        this(null, name, email, body, null);
    }

    public Boolean equals(User user) {
        return user != null && this.email.equals(user.email) && this.name.equals(user.name) && this.body.equals(user.body);
    }

    public UserVm toUserVm() {
        return new UserVm(id, name, email, body);
    }
}
