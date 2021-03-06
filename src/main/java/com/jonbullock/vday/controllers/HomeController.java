package com.jonbullock.vday.controllers;

import com.jonbullock.vday.models.Image;
import com.jonbullock.vday.services.ImageService;
import com.jonbullock.vday.services.PunService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private ImageService imageService = new ImageService();
    private PunService punService = new PunService();

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("valentine");
        Image image = imageService.getRandomImage();
        mav.addObject("image", image);
        mav.addObject("imageUrl", "/" + image.getUrl());
        mav.addObject("pun", punService.getRandomPunFor(image.getTags()));
        return mav;
    }

    @RequestMapping("/valentine")
    public ModelAndView getValentine() {
        ModelAndView mav = new ModelAndView("valentine");
        Image image = imageService.getRandomImage();
        mav.addObject("image", image);
        mav.addObject("imageUrl", "/" + image.getUrl());
        mav.addObject("pun", punService.getRandomPunFor(image.getTags()));
        return mav;
    }
}
