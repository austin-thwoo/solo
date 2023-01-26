package com.noah.solo.domain.user.user.domain;

public enum Role {
    ROLE_ADMIN("관리자", "ROLE_ADMIN"),
    ROLE_USER("일반 사용자", "ROLE_USER");

    private final String name;
    private final String role;

    Role(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

