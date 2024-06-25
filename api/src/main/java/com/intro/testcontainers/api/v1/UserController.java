package com.intro.testcontainers.api.v1;

import org.springframework.http.HttpStatus; // Import the HttpStatus class
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.intro.testcontainers.entity.User;
import com.intro.testcontainers.repository.UserRepository;
import com.intro.testcontainers.viewmodel.UserVm;
import com.intro.testcontainers.viewmodel.UsersVm;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UsersVm getUsers() {
        return new UsersVm(userRepository.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserVm createUser(@RequestBody UserVm userVm) {
        return userRepository.save(userVm.toEntity()).toUserVm();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserVm getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")).toUserVm();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser() {
        userRepository.deleteAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putUser(@PathVariable Long id, @RequestBody UserVm userVm) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.save(userVm.toEntity(id, user.version()));
    }
}
