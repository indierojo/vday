package com.jonbullock.vday.services;

import com.jonbullock.vday.models.Image;
import com.jonbullock.vday.util.FileUtils;
import com.jonbullock.vday.util.ImagePathParser;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ImageService {

    private final IntStream randomIntStream;
    private final List<Image> imageList;
    private final Random random;

    public ImageService() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL imagesUrl = classLoader.getResource("images");
        if(imagesUrl == null) {
            throw new RuntimeException("Cannot find images resource directory!");
        }

        List<String> imageFileList = FileUtils.getAllFilesInFolder(imagesUrl.getPath(), ".jpg");
        imageList = imageFileList.stream()
                .map(ImagePathParser::getImageFrom)
                .collect(Collectors.toList());
        random = new Random();
        randomIntStream = random.ints(0, imageFileList.size());
    }

    public Image getRandomImage() {
        return imageList.get(randomIntStream.findAny().getAsInt());
    }

    public Image getById(int id) {
        return imageList.get(id - 1);
    }

    public Image getRandomByTag(String tagName) {

        List<Image> matchingImages = imageList.stream()
                .filter(i -> i.containsTag(tagName))
                .collect(Collectors.toList());
        int numImages = matchingImages.size();
        int result = random.ints(0, numImages).findAny().getAsInt();
        return matchingImages.get(result);
    }
}
