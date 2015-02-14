package com.jonbullock.vday.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FileUtils {
    public static List<String> getAllFilesInFolder(String directory) {
        return getAllFilesInFolder(directory, "*.*");
    }

    public static List<String> getAllFilesInFolder(String directory, String extension) {
        Predicate<String> matchesExtension = filePath -> extension.equals("*.*") || filePath.endsWith(extension);

        List<String> directoryContents = fileList(directory);
        return directoryContents.stream()
                .filter(matchesExtension)
                .collect(Collectors.toList());
    }

    private static List<String> fileList(String directory) {
        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException ex) {
            throw new RuntimeException("Could not crawl directory tree: " + directory);
        }
        return fileNames;
    }

    public static String readToString(String textFilePath) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(textFilePath));
        return new String(encoded, Charset.defaultCharset());
    }
}
