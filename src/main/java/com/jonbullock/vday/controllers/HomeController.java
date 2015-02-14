package com.jonbullock.vday.controllers;

import com.jonbullock.vday.models.Image;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("image", new Image(1, "www.google.com", "cc", null));
        return mav;
    }
}
