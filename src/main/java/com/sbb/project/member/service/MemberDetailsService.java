package com.sbb.project.member.service;

import com.sbb.project.member.entity.Member;
import com.sbb.project.member.repository.MemberRepository;
import com.sbb.project.member.role.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> _member = memberRepository.findByusername(username);

        if (_member.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        Member member = _member.get();

        List<GrantedAuthority> auth = new ArrayList<>();

        if (username.startsWith("admin")) {
            auth.add(new SimpleGrantedAuthority(Grade.ADMIN.getValue()));
        } else {
            auth.add(new SimpleGrantedAuthority(Grade.MEMBER.getValue()));
        }

        return new User(member.getUsername(), member.getPassword(), auth);
    }
}
