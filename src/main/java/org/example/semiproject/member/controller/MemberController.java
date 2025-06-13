package org.example.semiproject.member.controller;

import lombok.extern.slf4j.Slf4j;

import org.example.semiproject.common.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    public String myinfo() {
      String returnPage = "member/myinfo2";

      return returnPage;
	}
		
    @GetMapping("/fetchMyinfo")
    public ResponseEntity<?> fetchMyinfo(Authentication authentication) {
        ResponseEntity<?> returnPage = ResponseEntity.status(401).body("인증되지 않은 사용자입니다.");
        if (authentication != null && authentication.isAuthenticated()) {
            // UserDetails에서 아이디 등 정보 추출
            CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
    
            returnPage = ResponseEntity.status(200).body(user);
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
