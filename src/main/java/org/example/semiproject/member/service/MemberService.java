package org.example.semiproject.member.service;

import org.example.semiproject.member.domain.Member;
import org.example.semiproject.member.dto.MemberDTO;
import org.example.semiproject.member.dto.LoginDTO;

public interface MemberService {

    boolean newMember(MemberDTO member);
    Member loginMember(LoginDTO member);

}
