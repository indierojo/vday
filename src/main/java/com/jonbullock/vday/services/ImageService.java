package com.jonbullock.vday.services;

import com.jonbullock.vday.models.Image;
import com.jonbullock.vday.util.FileUtils;
import com.jonbullock.vday.util.ImagePathParser;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ImageService {

    private final List<Image> imageList;
    private final Random random;

    public ImageService(String imagePath) {
        List<String> imageFileList = FileUtils.getAllFilesInFolder(imagePath, ".jpg");
        imageList = imageFileList.stream()
                .map(ImagePathParser::getImageFrom)
                .collect(Collectors.toList());
        random = new Random();
    }

    public Image getRandomImage() {

        IntStream intStream = random.ints(0, imageList.size());
        return imageList.get(intStream.findAny().getAsInt());
    }

    public Image getById(int id) {
        return imageList.stream().filter(i -> i.getId() == id).findFirst().get();
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
