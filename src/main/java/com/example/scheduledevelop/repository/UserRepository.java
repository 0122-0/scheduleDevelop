package com.example.scheduledevelop.repository;

import com.example.scheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByName(String name);
    Optional<User> findByEmail (String email);

    default User findUserByNameOrElseThrow(String name) {
        return findUserByName(name).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NO_CONTENT,
                        "Does not exist name = " + name)
        );

    }

    default User findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NO_CONTENT,
                                "Does not exist id = " + id
                        )
                );
    }



}
