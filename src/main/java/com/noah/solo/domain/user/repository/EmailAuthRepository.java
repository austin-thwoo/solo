package com.noah.solo.domain.user.repository;

import com.noah.solo.domain.user.auth.domain.EmailAuth;

import java.util.Optional;

public interface EmailAuthRepository {
    Optional<EmailAuth> findByEmail(String email);

    Long save(EmailAuth emailAuth);

    Optional<EmailAuth> findTopByEmailAndTypeAndExpiredAtBeforeNow(String email, EmailAuth.EmailAuthType type);

    boolean existsByEmailAndStatusAndType(String email, EmailAuth.EmailAuthStatus status, EmailAuth.EmailAuthType type);

    void deleteAllByEmail(String email);
}
