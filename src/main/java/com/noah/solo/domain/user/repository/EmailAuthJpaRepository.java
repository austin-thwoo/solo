package com.noah.solo.domain.user.repository;



import com.noah.solo.domain.user.auth.domain.EmailAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface EmailAuthJpaRepository extends JpaRepository<EmailAuth, Long> {
    Optional<EmailAuth> findByEmail(String email);

    Optional<EmailAuth> findFirstByEmailAndTypeAndExpiredAtGreaterThanEqualOrderByExpiredAtDesc(String email, EmailAuth.EmailAuthType type, LocalDateTime expiredAt);

    boolean existsByEmailAndStatusAndType(String email, EmailAuth.EmailAuthStatus status, EmailAuth.EmailAuthType type);

    void deleteAllByEmail(String email);
}
