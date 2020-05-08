package com.creaters.entity;


public class Achievements {

    private Integer id;
    private String name;
    private String url;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) { this.url = url; }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() { return url; }
}
