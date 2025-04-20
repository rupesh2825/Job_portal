package Joblists.JOBList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/findjob")
    public String showJobFinder() {
        return "findjob";
    }

    @GetMapping("/addjob")
    public String showJobAdder() {
        return "addjob";
    }
}
