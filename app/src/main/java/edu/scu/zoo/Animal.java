package edu.scu.zoo;

import java.io.Serializable;

/**
 * Created by niki on 1/19/15.
 */
public class Animal implements Serializable {

    private String name;
    private String thumbnail;
    private String image;
    private String description;

    public Animal(String name,String thumbnail,String image,String description){
        this.name=name;
        this.thumbnail=thumbnail;
        this.image=image;
        this.description=description;
    }
    public String getImage(){
        return image;
    }
    public String getThumbnail(){
        return thumbnail;
    }
    public  String getName(){
        return name;
    }
    public String getDescription(){return description ;}
}
