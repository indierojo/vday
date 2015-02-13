package controllers;

import models.Image;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/**")
@RestController
public class ImageController {

    @RequestMapping(method= RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Image image() {
        return new Image("image.jpg");
    }
}
