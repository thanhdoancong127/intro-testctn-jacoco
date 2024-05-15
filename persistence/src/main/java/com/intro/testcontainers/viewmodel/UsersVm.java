package com.intro.testcontainers.viewmodel;

import java.util.List;

import com.intro.testcontainers.entity.User;

public record UsersVm(List<User> users) {

    public Boolean contains(User user) {
        return users.stream().anyMatch(user::equals);
    }
}
