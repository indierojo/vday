package com.jonbullock.vday.controllers;

import com.jonbullock.vday.models.Image;
import com.jonbullock.vday.services.ImageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@RequestMapping("/images")
@RestController
public class ImageController {

    private ImageService imageService;

    @Autowired
    ServletContext context;

    @RequestMapping(value= "/{id}", method= RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void image(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
        initServices();

        response.setContentType("image/jpeg");
        Image image = imageService.getById(id);
        Path filePath = FileSystems.getDefault().getPath(image.getUrl());
        InputStream in = Files.newInputStream(filePath);
        IOUtils.copy(in, response.getOutputStream());
    }

    private void initServices() {
        if (imageService == null) {
            URL imagePath = context.getClassLoader().getResource("images");
            imageService = new ImageService(imagePath.getPath());
        }
    }
}
