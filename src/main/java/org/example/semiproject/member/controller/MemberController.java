package org.example.semiproject.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.semiproject.member.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String join() {
        return "member/join";
    }

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/myinfo")
    public String myinfo(Model model) {

        Member user = new Member(0,"abc123","abc123","abc123",
            "abc123@abc123.co.kr", LocalDateTime.now());

        model.addAttribute("loginUser", user);

        return "member/myinfo";
    }

}
