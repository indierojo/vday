package com.jonbullock.vday.models;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public class Image {
    private final List<String> tags;
    private final TextLocation textLocation;
    private final String url;
    private final int id;

    public Image(int id, String url, String textLocation, List<String> tags) {
        this.id = id;
        this.url = url;
        this.tags = tags;
        this.textLocation = TextLocation.getFromAbbreviation(textLocation);
    }

    @ModelAttribute("id")
    public int getId() { return id; }

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

    public boolean containsTag(String tagName) {
        return tags.contains(tagName);
    }


}
