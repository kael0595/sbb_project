package com.sbb.project.member.controller;

import com.sbb.project.member.dto.MemberDto;
import com.sbb.project.member.entity.Member;
import com.sbb.project.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String joinForm() {
        return "member/join";
    }

    @PostMapping("/join")
    public String join(@Valid MemberDto memberDto,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "member/join";
        }

        log.info("memberDto : {}", memberDto);

        Member member = memberService.join(memberDto);

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "member/login";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping("/mypage/{username}")
    public String mypage(@PathVariable("username") String username, Model model) {
        Member member = memberService.getMemberByusername(username);
        model.addAttribute("member", member);
        return "member/mypage";
    }

    @GetMapping("/mypage/{username}/update")
    public String updateForm(@PathVariable("username") String username, Model model) {
        Member member = memberService.getMemberByusername(username);
        model.addAttribute("member", member);
        return "member/update";
    }

    @PostMapping("/mypage/{username}/update")
    public String update(@PathVariable("username") String username, @Valid MemberDto memberDto,
                         BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "member/update";
        }

        Member member = memberService.getMemberByusername(username);

        memberService.update(member, memberDto);

        session.invalidate();

        return "redirect:/";

    }
}
