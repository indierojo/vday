package com.jonbullock.vday.services;

import com.jonbullock.vday.models.Image;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.*;

public class ImageServiceTest {
    @Test
    public void it_should_be_able_to_get_a_random_image_from_the_image_directory() throws Exception {
        ImageService imageService = getImageService();
        Image image = imageService.getRandomImage();

        assertNotNull(image);
    }

    @Test
    public void it_should_be_able_to_get_an_image_by_id() {
        ImageService imageService = getImageService();
        Image image = imageService.getById(1);

        assertNotNull(image);
        assertEquals(1, image.getId());

        image = imageService.getById(2);

        assertNotNull(image);
        assertEquals(2, image.getId());
    }

    @Test
    public void it_should_be_able_to_get_a_random_image_by_tag() {
        ImageService imageService = getImageService();
        Image image = imageService.getRandomByTag("fire");

        assertNotNull(image);
        assertTrue(image.containsTag("fire"));
    }

    private ImageService getImageService() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL imagesUrl = classLoader.getResource("images");
        if(imagesUrl == null) {
            throw new RuntimeException("Cannot find images resource directory!");
        }

        return new ImageService();
    }
}