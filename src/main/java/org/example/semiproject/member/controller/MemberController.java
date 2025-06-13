package org.example.semiproject.member.controller;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import org.example.semiproject.member.domain.Member;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @Value("${recaptcha_sitekey}")
    private String sitekey;

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("sitekey", sitekey);

        return "member/join";
    }

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/myinfo")
    public String myinfo(Model model, Authentication authentication) {
        String returnPage = "redirect:/member/login";

        if (authentication != null && authentication.isAuthenticated()) {
            // UserDetails에서 아이디 등 정보 추출
            User existUser = (User) authentication.getPrincipal();
            Member user = Member.builder()
                    .userid(existUser.getUsername())
                    .name("준비중...").email("준비중...") // 실제로는 DB에서 조회해야 함
                    .regdate(LocalDateTime.now()) // 현재 시간으로 설정
                    .build();

            model.addAttribute("loginUser", user);
            returnPage = "member/myinfo";
        }

        return returnPage;
    }

    // security가 로그아웃 처리해 줌!
    // @GetMapping("/logout")
    // public String logout(HttpSession session) {
    //     session.invalidate();

    //     return "redirect:/";
    // }

}
