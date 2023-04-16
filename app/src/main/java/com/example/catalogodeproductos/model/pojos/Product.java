package com.example.catalogodeproductos.model.pojos;

public class Product {

    private String key;
    private String title;
    private String price;
    private String location;
    private String urlImage;

    public Product(String key, String title, String price, String location, String urlImage) {
        this.key = key;
        this.title = title;
        this.price = price;
        this.location = location;
        this.urlImage = urlImage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
