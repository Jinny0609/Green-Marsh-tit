package com.tit.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoogleLoginController {
// 	@GetMapping("/")
//    public String home() {
//        return "home";
//    }
 
    @GetMapping("/login")
    public String login() {
        return "login";
    }
 
    @GetMapping("/login/oauth2/code/google")
    public String afterLogin() {
        return "googletest";
    }
    
}
