package com.jonbullock.vday.controllers;

import com.jonbullock.vday.models.Image;
import com.jonbullock.vday.services.ImageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@RequestMapping("/images")
@RestController
public class ImageController {

    ImageService imageService = new ImageService();

    @RequestMapping(value= "/{id}", method= RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void image(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        Image image = imageService.getById(id);
        Path filePath = FileSystems.getDefault().getPath(image.getUrl());
        InputStream in = Files.newInputStream(filePath);
        IOUtils.copy(in, response.getOutputStream());
    }
}
