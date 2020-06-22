package com.codeup.blog.models;

public class Ad {
    private String title;
    private String description;

    //constructor
    public Ad(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public String getTitle(){
        return title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
