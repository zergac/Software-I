package com.example.demo2;

/**
 *
 * @author Carolina Zerga
 */

public abstract class Part {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    /**
     * sets value to Part
     */
    public Part(int id, String name, int stock, double price, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * returns id value
     */
    public int getId() {
        return id;
    }

    /**
     * sets value to id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * returns name value
     */
    public String getName() {
        return name;
    }

    /**
     * sets value to name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns price value
     */
    public double getPrice() {
        return price;
    }

    /**
     * sets value to price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * returns inventory value
     */
    public int getStock() {
        return stock;
    }

    /**
     * sets inventory value
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * returns min value
     */
    public int getMin() {
        return min;
    }

    /**
     * sets value to min
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * returns max value
     */
    public int getMax() {
        return max;
    }

    /**
     * sets value to max
     */
    public void setMax(int max) {
        this.max = max;
    }





}
