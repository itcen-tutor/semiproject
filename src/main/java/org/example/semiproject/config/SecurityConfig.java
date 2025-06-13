package org.example.semiproject.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration // 해당 클래스가 스프링의 설정 클래스임을 명시
@EnableWebSecurity // Spring Security를 활성화시키는 어노테이션
@RequiredArgsConstructor // final이나 @NonNull이 붙은 필드에 대해 생성자 자동 생성
public class SecurityConfig {



}
