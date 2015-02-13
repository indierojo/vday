package com.jonbullock.vday.models;

import org.springframework.web.bind.annotation.ModelAttribute;

public class Image {
    public Image(String url) {
        this.url = url;
    }

    private String url;

    @ModelAttribute("url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
