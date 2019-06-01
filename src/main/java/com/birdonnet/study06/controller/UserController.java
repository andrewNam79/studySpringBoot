package com.birdonnet.study06.controller;

import com.birdonnet.study06.model.Users;
import com.birdonnet.study06.service.LoginService;
import com.birdonnet.study06.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @PostMapping("/joinProcess")
//    public String ctrJoinProcess(@RequestParam Long id, @RequestParam String user_name, @RequestParam String user_pw){
      public ModelAndView ctrJoinProcess(Users user){
        String returnPage;
        /*
        Users user = new Users();

        user.setId(id);
        user.setUser_name(user_name);
        user.setUser_pw(user_pw);
        */
        ModelAndView mav = new ModelAndView();
        returnPage = userService.joinUser(user);

        mav.addObject("User", user);
        mav.setViewName(returnPage);
        return mav;
    }

    @GetMapping("/joinModify")
    public String ctrJoinModify(Model model){
        return "joinModify";
    }

    @PostMapping("/loginProcess")
    public String ctrLoginProcess(@RequestParam Map<String, String> map){
        String page = loginService.login(map.get("id"), map.get("user_pw"));
        return page;
    }
}
