package ru.itis.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.forms.SignInForm;
import ru.itis.services.UserService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignInController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView showSignIn() {
        ModelAndView mav = new ModelAndView("signIn");
        mav.addObject("user", new SignInForm());
        return mav;
    }


    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    @SneakyThrows
    public String signIn(HttpServletResponse response,
                                     @ModelAttribute("user") SignInForm signInForm) {
        String cookieValue = userService.signIn(signInForm);
        if (cookieValue != null) {
            Cookie auth = new Cookie("auth", cookieValue);
            response.addCookie(auth);
            return "redirect:/profile";
        }
        return "redirect:/signIn";
    }

}
