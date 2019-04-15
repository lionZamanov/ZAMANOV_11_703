package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.forms.SignUpForm;
import ru.itis.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignUpController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public ModelAndView showSignUp() {
        ModelAndView mav = new ModelAndView("signUp");
        mav.addObject("user", new SignUpForm());
        return mav;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("user") SignUpForm user) {
        userService.signUp(user);
        return "redirect:/signIn";
    }
}
