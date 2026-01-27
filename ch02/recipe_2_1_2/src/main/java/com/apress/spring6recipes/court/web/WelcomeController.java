package com.apress.spring6recipes.court.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.Date;

// @Configuration에서 @ComponentScan 해놨으니 등록된다...
@Controller
// 아래 메서드 들에서 경로를 path로 처리하면 여긴 필요 없다...
// @RequestMapping("/welcome")
public class WelcomeController {

    // 이렇게 해 놓으면 /welcome으로 들어오는 GET 요청을 여기에 위임한다..누가?
    // 경로에 대한 GET은 최소한 만들어 둬야 한다...꼭 그래야 하나?
    // @RequestMapping(path = "/welcome", method = RequestMethod.GET)
    // 또는 간단하게...이게 낫네...
    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("today", new Date());
        return "welcome";
    }
}
