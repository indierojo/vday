package com.jonbullock.vday.controllers;

import com.jonbullock.vday.models.Image;
import com.jonbullock.vday.services.ImageService;
import com.jonbullock.vday.services.PunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.net.URL;

@Controller
public class HomeController {

    private ImageService imageService;
    private PunService punService;

    @Autowired
    ServletContext context;

    @RequestMapping("/")
    public ModelAndView index() {
        initServices();

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("image", new Image(1, "fake", "cc", null));
        return mav;
    }

    @RequestMapping("/valentine")
    public ModelAndView getValentine() {
        initServices();

        ModelAndView mav = new ModelAndView("valentine");
        Image image = imageService.getRandomImage();
        mav.addObject("image", image);
        mav.addObject("imageUrl", "/images/" + image.getId());
        mav.addObject("pun", punService.getRandomPunFor(image.getTags()));
        return mav;
    }

    private void initServices() {
        if (imageService == null) {
            URL imagePath = context.getClassLoader().getResource("images");
            imageService = new ImageService(imagePath.getPath());
        }
        if (punService == null) {
            URL punPath = context.getClassLoader().getResource("data/puns.json");
            punService = new PunService(punPath.getPath());
        }
    }
}
