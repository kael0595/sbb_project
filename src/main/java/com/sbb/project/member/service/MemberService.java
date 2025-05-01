package com.sbb.project.member.service;

import com.sbb.project.member.dto.MemberDto;
import com.sbb.project.member.entity.Member;
import com.sbb.project.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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
                .createDt(LocalDateTime.now())
                .build();
        return memberRepository.save(member);
    }

    public Member getMemberByusername(String name) {

        Optional<Member> _member = memberRepository.findByusername(name);

        if (_member.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        Member member = _member.get();

        return member;
    }

    public void update(Member member, MemberDto memberDto) {
        Member updateMember = member.toBuilder()
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .name(memberDto.getName())
                .nickname(memberDto.getNickname())
                .email(memberDto.getEmail())
                .addr1(memberDto.getAddr1())
                .addr2(memberDto.getAddr2())
                .updateDt(LocalDateTime.now())
                .build();
        memberRepository.save(updateMember);
    }
}
