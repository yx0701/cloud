package com.yx.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HtmlController {

    @PostMapping("/login")
    public String loginIndex(){
        return "";
    }
}
