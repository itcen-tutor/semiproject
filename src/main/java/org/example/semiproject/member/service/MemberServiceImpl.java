package org.example.semiproject.member.service;

import lombok.RequiredArgsConstructor;
import org.example.semiproject.member.domain.Member;
import org.example.semiproject.member.dto.MemberDTO;
import org.example.semiproject.member.dto.LoginDTO;
import org.example.semiproject.member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberMapper;
    private final PasswordEncoder passwordEncoder;

    public boolean newMember(MemberDTO member) {
        
        // 아이디 중복 체크
        if (memberMapper.countByUserid(member.getUserid()) > 0) {
            throw new IllegalStateException("이미 존재하는 아이디입니다!!");
        }

        // 이메일 중복 체크
        if (memberMapper.countByEmail(member.getEmail()) > 0) {
            throw new IllegalStateException("이미 존재하는 이메일입니다!!");
        }

        // 비밀번호 암호화
        member.setPasswd(passwordEncoder.encode(member.getPasswd()));

        int result = memberMapper.insertMember(member);
        return result == 1;  // 회원정보가 테이블 저장되었는지 여부에 따라
                             // true/false 반환
    }

    public Member loginMember(LoginDTO member) {
        Member findMember = memberMapper.findByUserid(member.getUserid());

        // 비밀번호 암호화
        // member.setPasswd(passwordEncoder.encode(member.getPasswd()));
        log.info("조회된 계정 : {}, 로그인 계정 : {}", findMember.getPasswd(), member.getPasswd());

        //if (findMember == null || !findMember.getPasswd().equals(member.getPasswd())) {
        if (findMember == null || !passwordEncoder.matches(member.getPasswd(), findMember.getPasswd())) { // security 사용시
            throw new IllegalStateException("아이디나 비밀번호가 일치하지 않습니다!!");
        }

        return findMember;
    }

}