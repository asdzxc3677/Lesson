package com.its.boardMember.controller;

import com.its.boardMember.dto.MemberDTO;
import com.its.boardMember.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member") //컨트룰러에 있는 모든 메서드들을 찿아주는 역할
public class MemberController {

    @Autowired //의존성을 줄여주는 역할하는 객체
    private MemberService memberService;

    @GetMapping("/save-form") // 회원가입 페이지
    public String saveForm(){
        return "memberPages/save";
    }

    @PostMapping("save") //회원가입
    public String save(@ModelAttribute MemberDTO memberDTO){
        boolean saveResult = memberService.save(memberDTO);
        if (saveResult){
            System.out.println("저장성공");
            return "/memberPages/login";
        }else {
            System.out.println("저장실패");
            return "memberPages/save-fail";
        }
    }

    @PostMapping("/duplicate-check") //아이디 중복체크
    public @ResponseBody String duplicateCheck(@RequestParam("memberId") String memberId){
        System.out.println("memberId =" + memberId); // @ResponseBody 는 ajax문법을 쓰기 위한 맵핑 이고
        String checkResult = memberService.duplicateCheck(memberId);
        return checkResult;
    }

    @GetMapping("/login-form") //로그인페이지
    public String loginForm(){
        return "memberPages/login";
    }

    @PostMapping("/login") //로그인
    public String login(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session){
        System.out.println("컨트롤러 디티오" + memberDTO);
        MemberDTO loginMember = memberService.login(memberDTO);
        System.out.println("컨트룰러"+loginMember);
        if (loginMember != null){ //로그인 됐을때 ( 로그인이 비워잇는 값이 아닐때)
            model.addAttribute("loginMember",loginMember); // model.addAttribute 는 가로안에 로그인 맴버의 정보를 가져간다는 내용
            session.setAttribute("loginId",loginMember.getMemberId());  // session.setAttribute 로그인한 값을 session 통해서 모든페이지를 쓸수 있다.
            session.setAttribute("id",loginMember.getId()); // 아이디를 session 통해서 모든페이지에 적용시킬수 있다.
            return "memberPages/main"; // 훗날 "redirect:/board/paging"; 으로 이동 "redirect: Mapping 주소로 이동하는 명령어
        }else {
            return "memberPages/login";
        }
    }

    @GetMapping("/logout") //로그아웃
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }

}
