package com.noah.solo.domain.user.auth.domain;

import com.noah.solo.domain.user.exception.InvalidEmailAuthCodeException;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_email_auth")
@Getter
public class EmailAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String authCode;

    @Enumerated(EnumType.STRING)
    private EmailAuthStatus status;

    @Enumerated(EnumType.STRING)
    private EmailAuthType type;

    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;

    public enum EmailAuthStatus {
        COMPLETE, READY
    }

    public enum EmailAuthType {
        SIGNUP, PASSWORD
    }

    protected EmailAuth() {
    }

    public EmailAuth(String email, String authCode, EmailAuthType type) {
        this.email = email;
        this.authCode = authCode;
        this.createdAt = LocalDateTime.now();
        this.expiredAt = LocalDateTime.now().plusMinutes(3);
        this.status = EmailAuthStatus.READY;
        this.type = type;
    }

    public void validateAuthCode(String targetAuthCode) {
        if (!this.authCode.equals(targetAuthCode)) {
            throw new InvalidEmailAuthCodeException();
        }
    }

    public void completeAuth() {
        this.status = EmailAuthStatus.COMPLETE;
    }
}
