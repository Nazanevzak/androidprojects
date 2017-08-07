package com.example.camel.imageparsingurljson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by camel on 1.8.2017.
 */

public class Contact {
    @SerializedName("products")
    private List<Details> products;

public static class Details{
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;


    @SerializedName("price")
    private String price;

    @SerializedName("image")
    private String image;

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPrice(){
        return price;
    }
    public String getImage(){
        return image;
    }

    }

    public List<Details> getProducts() {
        return products;
    }

    public void setProducts(List<Details> products) {
        this.products = products;
    }
}
