package com.example.demo2.demo2.Controller;

import com.example.demo2.demo2.Dto.MemberDto;
import com.example.demo2.demo2.Service.AdminService;
import com.example.demo2.demo2.Service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.lang.System.out;

@Controller
@RequiredArgsConstructor //생성자 주입
public class MemberController {
    private final MemberService memberService; //컴트롤러가 서비스클래스 자원 등을 사용할수있게 해줌
    private final AdminService adminService;
    @PostMapping("Member/save")
    public String savemember(@ModelAttribute MemberDto memberDto){
        out.println("MemberController.savemember");
        out.println("memberDto = " + memberDto);
        memberService.save(memberDto);

        return "redirect:/";
    }
    @PostMapping("/Member/login")
    public String login(@ModelAttribute MemberDto memberDto, HttpSession session, HttpServletResponse response, Model model) throws IOException {

        MemberDto loginresult = memberService.login(memberDto);
        if(loginresult!=null){
            session.setAttribute("loginId",loginresult.getMemberId());
            String temp = loginresult.getMemberId();
            if(temp.equals("admin")){
                List<MemberDto> memberDtoList= memberService.findAll();
                model.addAttribute("memberList",memberDtoList);
                return "admin";

            }
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('일반유저 로그인성공했습니다.');</script>");
            out.flush();
            return "Manualinput";

        }else{
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('로그인 정보를 확인해주세요.'); history.go(-1);</script>");
            out.flush();
            return "redirect:/";


        }
    }
    @GetMapping("/member/")
    public String findAll(Model model){
       List<MemberDto> memberDtoList= memberService.findAll();
        model.addAttribute("memberList",memberDtoList);
        return "list";
    }

    @GetMapping("/member/{num}")
    //경로 상의 문자 받아옴
    public String findByNum(@PathVariable Long num,Model model){
        //
        MemberDto memberDto = memberService.findByNum(num);
        model.addAttribute("member",memberDto);
        return "detail";
    }

    @GetMapping("/member/upadte")
    public String updateForm(HttpSession session,Model model){
       String myId = (String) session.getAttribute("loginId");
       MemberDto memberDto = memberService.updateForm(myId);
       model.addAttribute("updateMember",memberDto);
        return "update";

    }
    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberDto memberDto){
        memberService.update(memberDto);
        return "redirect:/member/"+memberDto.getNum();
    }


    @GetMapping("/member/delete/{num}")
    public String deleteByNum(@PathVariable Long num){
        memberService.deleteByNum(num);
        return "redirect:/admin";
    }
    @GetMapping("/member/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";

    }

    @PostMapping("/member/id-check")
    public @ResponseBody String idCheck(@RequestParam("memberId") String memberId){
        out.println("memberId = " + memberId);
        String checkResult = memberService.idCheck(memberId);
        return checkResult;
//        if(checkResult != null){
//            return "ok";
//        }else {
//            return "no";
//        }
    }


}
