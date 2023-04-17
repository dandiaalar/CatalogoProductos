package com.example.catalogodeproductos.model.pojos;

public class Product {

    private String key;
    private String title;
    private String salePrice;
    private String sellernames;
    private String thumbnailImage;

    public Product(String key, String title, String salePrice, String sellernames, String thumbnailImage) {
        this.key = key;
        this.title = title;
        this.salePrice = salePrice;
        this.sellernames = sellernames;
        this.thumbnailImage = thumbnailImage;
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

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getSellernames() {
        return sellernames;
    }

    public void setSellernames(String sellernames) {
        this.sellernames = sellernames;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }
}
