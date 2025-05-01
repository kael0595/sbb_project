package com.sbb.project.member.entity;

import com.sbb.project.base.entity.BaseEntity;
import com.sbb.project.board.entity.Board;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member extends BaseEntity {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String nickname;

    @NotNull
    private String email;

    @NotNull
    private String name;

    private String addr1;

    private String addr2;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Board> boardList;
}
