package com.intro.testcontainers.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.intro.testcontainers.entity.User;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long>{

}
