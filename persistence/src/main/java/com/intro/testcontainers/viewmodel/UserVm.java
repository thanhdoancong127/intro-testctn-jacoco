package com.intro.testcontainers.viewmodel;

import com.intro.testcontainers.entity.User;

import lombok.Builder;

@Builder
public record UserVm(
    Long id,
    String name,
    String email,
    String body
) {
    public UserVm(String name, String email, String body) {
        this(null, name, email, body);
    }
    public UserVm fromUser(User user) {
        return new UserVm(user.id(), user.name(), user.email(), user.body());
    }

    public User toEntity() {
        return new User(null, name, email, body, null);
    }

    public User toEntity(Long id, Integer version) {
        return new User(id, name, email, body, version);
    }

    public User toEntity(Long id) {
        return new User(id, name, email, body, null);
    }

    public Boolean equals(UserVm userVm) {
        return userVm != null && this.name().equals(userVm.name()) && this.email().equals(userVm.email()) && this.body().equals(userVm.body());
    }
}
