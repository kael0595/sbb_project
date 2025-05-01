package com.sbb.project.board.entity;

import com.sbb.project.base.entity.BaseEntity;
import com.sbb.project.member.entity.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board extends BaseEntity {

    private String title;

    private String content;

    @ManyToOne
    private Member author;

}
