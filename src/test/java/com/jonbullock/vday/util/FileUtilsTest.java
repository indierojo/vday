package com.jonbullock.vday.util;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileUtilsTest {

    @Test
    public void testGetAllFilesInFolder() throws Exception {
        String imagesPath = getImagePath();
        List<String> fileList = FileUtils.getAllFilesInFolder(imagesPath);

        assertEquals(3, fileList.size());
    }

    private String getImagePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL imageLocation = classLoader.getResource("images");
        if(imageLocation == null) {
            throw new RuntimeException("Can't find test resource: images/");
        }
        return imageLocation.getPath();
    }

    @Test
    public void testGetAllFilesInFolder_should_match_an_extension() throws Exception {
        String imagesPath = getImagePath();

        List<String> fileList = FileUtils.getAllFilesInFolder(imagesPath, ".jpg");
        assertEquals(2, fileList.size());
    }

    @Test
    public void testReadFileToString_should_read_a_file() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL textFileLocation = classLoader.getResource("images/not_an_image.txt");
        if(textFileLocation == null) {
            throw new RuntimeException("Can't find test resource: images/not_an_image.txt");
        }

        String fileContents = FileUtils.readToString(textFileLocation.getPath());
        String expected = "This is used to test the file utils class.";
        assertEquals(expected, fileContents);
    }
}