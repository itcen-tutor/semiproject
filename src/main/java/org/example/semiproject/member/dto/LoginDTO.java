package org.example.semiproject.member.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO {

    private String userid;
    private String passwd;

}