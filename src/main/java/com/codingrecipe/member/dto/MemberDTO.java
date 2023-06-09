package com.codingrecipe.member.dto;

import com.codingrecipe.member.entity.MemberEntity;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberName;
    private String memberPassword;

    public static MemberDTO toMemberDTO(MemberEntity member) {
        MemberDTO result = new MemberDTO();
        result.setMemberEmail(member.getMemberEmail());
        result.setMemberPassword(member.getMemberPassword());
        result.setMemberName(member.getMemberName());
        return result;
    }
}
