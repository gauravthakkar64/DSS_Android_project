package com.example.gaurav.crudretrofit.model;

public class Workspace {

    private int id;
    private String Name;
    private String description;
    private double price;
    private int image;


    public Workspace(int id, String name, String description, double price, int image) {
        this.id = id;
        Name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;

    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

}
