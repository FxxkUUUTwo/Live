package com.other.project.live.model;

/**
 * Created by wanghaixin on 16/11/29.
 */
public class HotModel {
    private String title;
    private String img;
    private String uri;


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public HotModel(String img, String title, String uri) {
        this.img = img;
        this.title = title;
        this.uri = uri;
    }

    public HotModel() {
    }
}
