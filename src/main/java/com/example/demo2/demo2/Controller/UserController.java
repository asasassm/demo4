package com.example.demo2.demo2.Controller;

import com.example.demo2.demo2.Dto.AddTripDto;
import com.example.demo2.demo2.Dto.TripDto;
import com.example.demo2.demo2.Service.AdminService;
import com.example.demo2.demo2.Service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final AdminService adminService;
    private final TripService tripService;

    @GetMapping("/usertrip/list")
    public String findAlltrip(Model model){
        List<AddTripDto> addTripDtoList= adminService.findAlltrip();
        model.addAttribute("usertrip",addTripDtoList);
        return "usertrip"; //
    }
    //aco 내 여행지 보기
    @GetMapping("/usertrip/aco")
    public String usertripaco(Model model){
        List<TripDto> tripDtoList= tripService.findAllusertrip();
        model.addAttribute("usertripok",tripDtoList);
        return "aco"; //
    }
    @GetMapping("/usertrip/ok")
    public String usertripok(){

        return "redirect:/via/"; //
    }



}
