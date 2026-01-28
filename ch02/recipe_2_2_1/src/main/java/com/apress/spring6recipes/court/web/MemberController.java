package com.apress.spring6recipes.court.web;

import com.apress.spring6recipes.court.domain.Member;
import com.apress.spring6recipes.court.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("guests", memberService.list());
        return "memberList";
    }

    @RequestMapping(path = {"/remove", "/delete"}, method = RequestMethod.GET)
    public String delete(@RequestParam("name") String name) {
        memberService.remove(name);
        return "redirect:";
    }

    @RequestMapping("/display/{member}")
    public String display(@PathVariable("member") String member, Model model) {
        model.addAttribute("member", memberService.find(member).orElse(null));
        return "member";
    }

    @RequestMapping
    public void memberList() {}

    public void memberLogic(String member) {}
}
