package com.sbb.project.member.service;

import com.sbb.project.member.dto.MemberDto;
import com.sbb.project.member.entity.Member;
import com.sbb.project.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public Member join(MemberDto memberDto) {
        Member member = Member.builder()
                .username(memberDto.getUsername())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .name(memberDto.getName())
                .nickname(memberDto.getNickname())
                .email(memberDto.getEmail())
                .addr1(memberDto.getAddr1())
                .addr2(memberDto.getAddr2())
                .build();
        return memberRepository.save(member);
    }
}
