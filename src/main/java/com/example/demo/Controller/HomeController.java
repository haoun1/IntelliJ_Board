package com.example.demo.Controller;

import com.example.demo.Dto.UserDto;
import com.example.demo.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class HomeController {

    private UserService uService;

    public HomeController(UserService u)
    {
        this.uService=u;
    }
    @GetMapping(value = "/")
    public String home(Model model)
    {
        List<UserDto> userList=uService.getUserList();
        model.addAttribute("userList", userList);
        return "home";
    }
    @PostMapping(value = "/")
    public String register(RedirectAttributes redirect, UserDto user)
    {
        if(uService.join(user))
            redirect.addAttribute("msg", "회원가입이 완료되었습니다");
        else
            redirect.addAttribute("msg", "중복된 아이디가 존재합니다.");
        return "redirect:result_alarm";
    }

    @RequestMapping(value = "/result_alarm")
    public String result_alarm(@RequestParam("msg") String param, Model model)
    {
        model.addAttribute("msg", param);
        return "result_alarm";
    }
}
