package com.noah.solo.domain.user.repository;


import com.noah.solo.domain.user.auth.domain.EmailAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmailAuthRepositoryImpl implements EmailAuthRepository {

    private final EmailAuthJpaRepository emailAuthJpaRepository;

    @Override
    public Optional<EmailAuth> findByEmail(String email) {
        return emailAuthJpaRepository.findByEmail(email);
    }

    @Override
    public Long save(EmailAuth emailAuth) {
        return emailAuthJpaRepository.save(emailAuth).getId();
    }

    @Override
    public Optional<EmailAuth> findTopByEmailAndTypeAndExpiredAtBeforeNow(String email, EmailAuth.EmailAuthType type) {
        return emailAuthJpaRepository.findFirstByEmailAndTypeAndExpiredAtGreaterThanEqualOrderByExpiredAtDesc(email, type, LocalDateTime.now());
    }

    @Override
    public boolean existsByEmailAndStatusAndType(String email, EmailAuth.EmailAuthStatus status, EmailAuth.EmailAuthType type) {
        return emailAuthJpaRepository.existsByEmailAndStatusAndType(email, status, type);
    }

    @Override
    public void deleteAllByEmail(String email) {
        emailAuthJpaRepository.deleteAllByEmail(email);
    }
}
