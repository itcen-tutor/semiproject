package org.example.semiproject.common.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.semiproject.member.domain.Member;
import org.example.semiproject.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

		@Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        Member member = memberRepository.findByUserid(userid);
        if (member == null) throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + userid);

        log.info("로그인한 사용자 : {}", member);
        return new CustomUserDetails(
                member.getUserid(),
                member.getPasswd(),
                member.getName(),
                member.getEmail(),
                member.getRegdate(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }

}

