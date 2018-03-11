package com.example.sachinpc.restshoecommerce;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by SachinPC on 3/6/2018.
 */

public class Product implements Serializable {

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @SerializedName("id")
    int id;
    @SerializedName("size")
    int size;
    @SerializedName("price")
    int price;
    @SerializedName("name")
    String name;
    @SerializedName("type")
    String type;
    @SerializedName("gender")
    String gender;
    @SerializedName("img")
    String img;




    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }
    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    @SerializedName("description")
    String description;


    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }




}
