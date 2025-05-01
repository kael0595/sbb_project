package com.sbb.project.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private String username;

    private String password;

    private String passwordCnf;

    private String nickname;

    private String name;

    private String email;

    private String addr1;

    private String addr2;
}
