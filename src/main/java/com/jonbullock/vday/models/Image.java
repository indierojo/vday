package com.jonbullock.vday.models;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public class Image {
    private final List<String> tags;
    private final TextLocation textLocation;
    private final String url;

    public Image(String url, String textLocation, List<String> tags) {
        this.url = url;
        this.tags = tags;
        this.textLocation = TextLocation.getFromAbbreviation(textLocation);
    }

    @ModelAttribute("url")
    public String getUrl() {
        return url;
    }

    @ModelAttribute("tags")
    public List<String> getTags() {
        return tags;
    }

    @ModelAttribute("textLocation")
    public TextLocation getTextLocation() {
        return textLocation;
    }
}
