package com.example.demo2.demo2.Controller;

import com.example.demo2.demo2.Dto.MemberDto;
import com.example.demo2.demo2.Dto.TripDto;
import com.example.demo2.demo2.Service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static java.lang.System.out;

@Controller
@RequiredArgsConstructor //생성자 주입
public class TripController {
private final TripService tripService;

    @PostMapping("/save/via")
    public String savetrip(@ModelAttribute TripDto tripDto){
        out.println("TripController.savetrup");
        out.println("memberDto = " + tripDto);
        tripService.save(tripDto);

        return "redirect:/via/";
    }
    @GetMapping("/save/delete/{tripNum}")
    public String deleteByNum(@PathVariable Long tripNum){
        tripService.deleteByNum(tripNum);
        return "redirect:/aco";
    }


}
