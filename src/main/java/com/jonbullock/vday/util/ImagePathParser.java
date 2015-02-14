package com.jonbullock.vday.util;

import com.jonbullock.vday.models.Image;

import java.util.ArrayList;
import java.util.List;

public class ImagePathParser {
    public static Image getImageFrom(String imageUrl) {
        String fileName = imageUrl;
        if(fileName.lastIndexOf("/") > -1) {
            fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
        }

        String[] fileNameComponents = fileName.split("_");

        String idAsString = fileNameComponents[0];
        int id = Integer.parseInt(idAsString);
        String textLocationAbbr = fileNameComponents[1];
        // skipping first two to get to the tags
        List<String> tags = new ArrayList<>(fileNameComponents.length - 2);
        for (int i = 2; i < fileNameComponents.length; i++) {
            tags.add(fileNameComponents[i].replace(".jpg", ""));
        }
        return new Image(id, imageUrl, textLocationAbbr, tags);
    }
}
