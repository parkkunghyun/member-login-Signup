package com.codingrecipe.member.dto;

import com.codingrecipe.member.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDTO {
    private String memberEmail;
    private String memberPassword;

    public static LoginDTO toLoginDTO(MemberEntity member) {
        LoginDTO result = new LoginDTO();
        result.setMemberEmail(member.getMemberEmail());
        result.setMemberPassword(member.getMemberPassword());
        return result;
    }
}
