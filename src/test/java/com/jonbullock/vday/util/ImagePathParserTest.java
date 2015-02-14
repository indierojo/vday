package com.jonbullock.vday.util;

import com.jonbullock.vday.models.Image;
import com.jonbullock.vday.models.TextLocation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ImagePathParserTest {

    @Test
    public void testGetImageFrom_should_load_tags_text_location_and_path() throws Exception {
        String imagePath = "1_cc_fire_hot_heat.jpg";
        List<String> expectedTags = new ArrayList<>();
        expectedTags.add("fire");
        expectedTags.add("hot");
        expectedTags.add("heat");

        Image result = ImagePathParser.getImageFrom(imagePath);
        assertNotNull(result);
        assertEquals(imagePath, result.getUrl());
        assertEquals(expectedTags, result.getTags());
        assertEquals(TextLocation.CenterCenter, result.getTextLocation());
    }
}