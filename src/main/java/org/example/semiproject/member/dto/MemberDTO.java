package org.example.semiproject.member.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

    private String userid;
    private String passwd;
    private String name;
    private String email;

}