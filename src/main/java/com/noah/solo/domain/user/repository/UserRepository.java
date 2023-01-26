package com.noah.solo.domain.user.repository;

import com.noah.solo.domain.user.user.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    Optional<User> findById(Long userId);

    Long save(User user);
}
