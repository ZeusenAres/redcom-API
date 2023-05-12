package com.redcom.redcom.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;

    private String product_name;

    private int price;

    private String product_type;

    private String product_properties;

    private String product_description;

    private String category;

    private String product_image;

    public Products()
    {

    }

    public int getId()
    {
        return product_id;
    }

    public int setId(int id)
    {
        return product_id = id;
    }

    public String getProductName()
    {
        return product_name;
    }

    public String setProductName(String name)
    {
        return product_name = name;
    }

    public int getPrice()
    {
        return price;
    }

    public int setPrice(int price)
    {
        return this.price = price;
    }

    public String getProductType()
    {
        return product_type;
    }

    public String setProductType(String type)
    {
        return product_type = type;
    }

    public String getProductProperties()
    {
        return product_properties;
    }

    public String setProductProperties(String properties)
    {
        return product_properties = properties;
    }

    public String getProductDescription()
    {
        return product_description;
    }

    public String setProductDescription(String description)
    {
        return product_description = description;
    }

    public String getProductCategory()
    {
        return category;
    }

    public String setProductCategory(String category)
    {
        return this.category = category;
    }

    public String getProductImage()
    {
        return product_image;
    }

    public String setProductImage(String image)
    {
        return product_image = image;
    }
}
