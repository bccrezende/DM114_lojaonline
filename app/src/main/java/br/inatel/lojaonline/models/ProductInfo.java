package br.inatel.lojaonline.models;

import java.io.Serializable;

/**
 * Created by bccre on 25/06/2016.
 */
public class ProductInfo implements Serializable {
    private long id;
    private String productID;
    private String name;
    private String model;
    private int code;
    private float price;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getCode() {
        return code;
    }

    public float getPrice() {
        return price;
    }
//getters and setters
}
