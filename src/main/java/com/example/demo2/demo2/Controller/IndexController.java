package com.example.demo2.demo2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping
    public String index(){return "index";}
    @GetMapping("/savemember")
    public String signup(){return "savemember";}
    @GetMapping("/admin")
    public String adminpage(){return "admin";}
    @GetMapping("/test2")
    public String test2(){
        return "test2";
    }
    @GetMapping("/test3")
    public String test3(){
        return "test3";
    }
    @GetMapping("/via/")
    public String Manualinput(){
        return "Manualinput";
    }
    @GetMapping("/aco")
    public String aco(){
        return "aco";
    }





}
