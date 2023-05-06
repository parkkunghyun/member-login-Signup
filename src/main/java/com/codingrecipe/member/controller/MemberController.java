package com.codingrecipe.member.controller;

import com.codingrecipe.member.dto.LoginDTO;
import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String list(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        // email이랑 이름만 나와야하는거 아님?
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    @GetMapping("/save")
    public String saveForm(Model model) {

        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        log.info("{} ", memberDTO);

        memberService.save(memberDTO);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, HttpSession session) {
        LoginDTO result = memberService.login(loginDTO);
        if(result != null) {
            session.setAttribute("loginEmail", result.getMemberEmail());
            log.info("session= {}", session);
            return "main";
        }

        return "login";

    }
}
