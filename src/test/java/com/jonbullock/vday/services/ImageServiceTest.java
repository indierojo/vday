package com.jonbullock.vday.services;

import com.jonbullock.vday.models.Image;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImageServiceTest {
    @Test
    public void it_should_be_able_to_get_a_random_image_from_the_image_directory() throws Exception {
        ImageService imageService = new ImageService();
        Image image = imageService.getRandomImage();

        assertNotNull(image);
    }
}