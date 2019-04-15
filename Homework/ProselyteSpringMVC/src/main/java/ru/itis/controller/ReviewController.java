package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.models.Review;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.User;
import ru.itis.repositories.UserRepository;
import ru.itis.services.ReviewService;

@Controller
public class ReviewController {

    @Autowired
    public ReviewService reviewService;

    @Autowired
    public UserRepository userRepository;

    @RequestMapping(value = "review/{review-id}", method = RequestMethod.GET)
    public String show(@PathVariable("review-id") Long reviewId, Model model) {
        Review currentReview = reviewService.get(reviewId);
        model.addAttribute("review", currentReview);
        return "review/show";
    }

    @RequestMapping(value = "review/new", method = RequestMethod.GET)
    public ModelAndView review() {
        ModelAndView mav = new ModelAndView("review/new");
        mav.addObject("review", new Review());
        return mav;
    }

    @RequestMapping(value = "review/new", method = RequestMethod.POST)
    public String addReview(@ModelAttribute("review") Review review, @CookieValue("auth") String userCookie) {
        User currentUser = userRepository.getByCookie(userCookie);
        review.setUser(currentUser);
        reviewService.add(review);
        return "redirect:/profile";
    }

}
