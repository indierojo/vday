package com.jonbullock.vday.services;

import com.jonbullock.vday.models.Image;
import com.jonbullock.vday.util.FileUtils;
import com.jonbullock.vday.util.ImagePathParser;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ImageService {

    private final IntStream randomIntStream;
    private final List<String> imageFileList;

    public ImageService() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL imagesUrl = classLoader.getResource("images");
        if(imagesUrl == null) {
            throw new RuntimeException("Cannot find images resource directory!");
        }

        imageFileList = FileUtils.getAllFilesInFolder(imagesUrl.getPath(), ".jpg");

        Random random = new Random();
        randomIntStream = random.ints(0, imageFileList.size());
    }

    public Image getRandomImage() {
        String imagePath = imageFileList.get(randomIntStream.findFirst().getAsInt());
        return ImagePathParser.getImageFrom(imagePath);
    }
}
