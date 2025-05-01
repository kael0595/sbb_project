package com.sbb.project.member.role;

import lombok.Getter;

@Getter
public enum Grade {
    ADMIN("ROLE_ADMIN"),
    MEMBER("ROLE_MEMBER");

    private final String value;

    Grade(String value) {
        this.value = value;
    }
}
