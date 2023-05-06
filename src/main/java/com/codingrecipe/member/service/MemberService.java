package com.codingrecipe.member.service;

import com.codingrecipe.member.dto.LoginDTO;
import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.entity.MemberEntity;
import com.codingrecipe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        MemberEntity member = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(member);
    }

    public LoginDTO login(LoginDTO loginDTO) {
        Optional<MemberEntity> entity = memberRepository.findByMemberEmail(loginDTO.getMemberEmail());
        if(entity.isPresent()) {
            MemberEntity member = entity.get();
            if(member.getMemberPassword().equals(loginDTO.getMemberPassword())) {
                LoginDTO result =  LoginDTO.toLoginDTO(member);
                return  result;
            }
            return null;
        }
        return  null;
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> all = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for(MemberEntity member: all) {
            memberDTOList.add(MemberDTO.toMemberDTO(member));
        }
        return memberDTOList;
    }
}
