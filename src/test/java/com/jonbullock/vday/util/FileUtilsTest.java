package com.jonbullock.vday.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import sun.security.util.Cache;

import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;

public class FileUtilsTest {

    @Test
    public void testGetAllFilesInFolder() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String imagesPath = classLoader.getResource("images").getPath();
        List<String> fileList = FileUtils.getAllFilesInFolder(imagesPath);

        assertEquals(3, fileList.size());
    }

    @Test
    public void testGetAllFilesInFolder_should_match_an_extension() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String imagesPath = classLoader.getResource("images").getPath();

        List<String> fileList = FileUtils.getAllFilesInFolder(imagesPath, ".jpg");
        assertEquals(2, fileList.size());
    }
    }
}