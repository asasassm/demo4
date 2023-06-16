package com.example.demo2.demo2.Controller;

import com.example.demo2.demo2.Dto.AddTripDto;
import com.example.demo2.demo2.Dto.MemberDto;
import com.example.demo2.demo2.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
private final AdminService adminService;
    @PostMapping("/admin/save") //어드민 여행지 추가
    public String savetrip(@ModelAttribute AddTripDto addTripDto){
        adminService.save(addTripDto);

        return "redirect:/admin";
    }

    @GetMapping("/admin/list")
    public String findAlltrip(Model model){
        List<AddTripDto> addTripDtoList= adminService.findAlltrip();
        model.addAttribute("tripList",addTripDtoList);
        return "triplist"; //
    }
    @GetMapping("/admin/delete/{tNum}")
    public String deleteBytNum(@PathVariable Long tNum){
        adminService.deleteBytNum(tNum);
        return "redirect:/triplist";
    }
}
