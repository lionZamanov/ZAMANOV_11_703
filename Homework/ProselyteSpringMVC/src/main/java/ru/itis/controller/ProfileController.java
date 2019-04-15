package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.User;
import ru.itis.repositories.UserRepository;

@Controller
public class ProfileController {

    @Autowired
    public UserRepository userRepository;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView index(@CookieValue("auth") String userCookie) {
        User currentUser = userRepository.getByCookie(userCookie);
        ModelAndView mv = new ModelAndView("userProfile");
        mv.addObject("user", currentUser);
        return mv;
    }

}
