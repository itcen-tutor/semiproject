package org.example.semiproject.member.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

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
    public String myinfo(HttpSession session, Model model) {
        String returnUrl = "member/login";

        // 세션변수가 생성되어 있다면 myinfo로 이동가능
        if (session.getAttribute("loginUser") != null) {
            model.addAttribute("loginUser", session.getAttribute("loginUser"));
            returnUrl = "member/myinfo";
        }
            
        return returnUrl;
    }

    // security가 로그아웃 처리해 줌!
    // @GetMapping("/logout")
    // public String logout(HttpSession session) {
    //     session.invalidate();

    //     return "redirect:/";
    // }

}
