package com.sbb.project;

import com.sbb.project.member.entity.Member;
import com.sbb.project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final MemberService memberService;

    @GetMapping("/")
    public String index(Model model,
                        @AuthenticationPrincipal User member) {

        if (member != null) {
            Member loginMember = memberService.getMemberByusername(member.getUsername());
            model.addAttribute("member", loginMember);
        }

        return "index";
    }
}
