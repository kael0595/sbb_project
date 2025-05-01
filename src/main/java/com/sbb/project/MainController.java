package com.sbb.project;

import com.sbb.project.member.entity.Member;
import com.sbb.project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MemberService memberService;

    @GetMapping("/")
    public String index(Model model,
                        Principal principal) {

        Member member = memberService.getMemberByusername(principal.getName());

        model.addAttribute("member", member);

        return "index";
    }
}
