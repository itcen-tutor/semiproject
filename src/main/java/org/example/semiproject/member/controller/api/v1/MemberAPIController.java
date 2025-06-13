package org.example.semiproject.member.controller.api.v1;

import org.example.semiproject.member.domain.Member;
import org.example.semiproject.member.dto.MemberDTO;
import org.example.semiproject.member.dto.LoginDTO;
import org.example.semiproject.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import org.example.semiproject.common.jwt.JwtTokenProvider;
import org.example.semiproject.common.utils.GoogleRecaptchaService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberAPIController {

    private final MemberService memberService;
    private final GoogleRecaptchaService googleRecaptchaService;
    private final JwtTokenProvider jwtTokenProvider;

    // ResponseEntity는 스프링에서 HTTP와 관련된 기능을 구현할때 사용
    // 상태코드, HTTP헤더, HTTP본문등을 명시적으로 설정 가능
    @PostMapping("/join")
    public ResponseEntity<?> joinok(MemberDTO member, String recaptchaToken) {
      ResponseEntity<?> response = ResponseEntity.internalServerError().build();

      log.info("submit된 회원 정보 : {}", member);
      log.info("submit된 recaptchaToken 정보 : {}", recaptchaToken);

      try {
          // 정상 처리시 상태코드 200으로 응답
          if (googleRecaptchaService.verifyRecaptcha(recaptchaToken))
              memberService.newMember(member);
          else
              throw new IllegalStateException("자동가입 방지 오류!!");
          response = ResponseEntity.ok().build();
      } catch (IllegalStateException e) {
          // 비정상 처리시 상태코드 400으로 응답 - 클라이언트 잘못
          // 중복 아이디나 중복 이메일 사용시
          response = ResponseEntity.badRequest().body(e.getMessage());
          e.printStackTrace();
      } catch (Exception e) {
          // 비정상 처리시 상태코드 500으로 응답 - 서버 잘못
          e.printStackTrace();
      }

      return response;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginok(LoginDTO member, String recaptchaToken) {
        // 로그인 처리시 기타오류 발생에 대한 응답코드 설정
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit된 로그인 정보 : {}", member);
        log.info("submit된 응답 토큰 : {}", recaptchaToken);

        try {
            //if (!googleRecaptchaService.verifyRecaptcha(recaptchaToken))
            //    throw new IllegalStateException("자동가입 방지 오류!!");

            // 정상 처리시 상태코드 200으로 응답
            Member loginUser = memberService.loginMember(member);

            // JWT 토큰 발급
            String jwt = jwtTokenProvider.generateToken(loginUser.getUserid());
            log.info("jwt: {}", jwt);

            //response = ResponseEntity.ok().body("로그인 성공했습니다!!");
            response = ResponseEntity.ok().body(Map.of("token", jwt, "message", "로그인 성공했습니다!!"));
        } catch (IllegalStateException e) {
            // 비정상 처리시 상태코드 400으로 응답 - 클라이언트 잘못
            // 아이디나 비밀번호 잘못 입력시
            response = ResponseEntity.badRequest().body(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // 비정상 처리시 상태코드 500으로 응답 - 서버 잘못
            e.printStackTrace();
        }

        return response;
    }
    
}

