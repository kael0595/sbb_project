package com.sbb.project.member.entity;

import com.sbb.project.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member extends BaseEntity {

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String name;

    private String addr1;

    private String addr2;
}
