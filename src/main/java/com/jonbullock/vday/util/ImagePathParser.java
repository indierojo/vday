package com.jonbullock.vday.util;

import com.jonbullock.vday.models.Image;

import java.util.ArrayList;
import java.util.List;

public class ImagePathParser {
    public static Image getImageFrom(String imagePath) {
        if(imagePath.lastIndexOf("/") > -1) {
            imagePath = imagePath.substring(imagePath.lastIndexOf("/"), imagePath.length());
        }

        String[] imagePathComponents = imagePath.split("_");

        String textLocationAbbr = imagePathComponents[1];
        // skipping first two to get to the tags
        List<String> tags = new ArrayList<>(imagePathComponents.length - 2);
        for (int i = 2; i < imagePathComponents.length; i++) {
            tags.add(imagePathComponents[i].replace(".jpg", ""));
        }
        return new Image(imagePath, textLocationAbbr, tags);
    }
}
