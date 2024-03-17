package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {
    private ObservableList<Part> associatedParts;
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    /**
     * initializes product value
     */
    public Product(int id, String name, int stock, double price, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
        associatedParts = FXCollections.observableArrayList();
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
     * sets value to inventory
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
     * return max value
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

    /**
     * adds a part to the associatedParts ObservableList
     */
    public void setAssociatedPart(Part part){
        associatedParts.add(part);
    }

    /**
     * deletes a part from the associatedParts ObservableList
     */
    public boolean deleteAssociatedPart(Part part){
        ObservableList<Part> list =  FXCollections.observableArrayList();
        for (int i = 0; i < associatedParts.size(); i++){
            Part p = associatedParts.get(i);
            if (part.getId() != p.getId()){
                list.add(p);
            }
        }
        if (list.size() == associatedParts.size()){
            return false;
        }
        associatedParts = list;
        return true;
    }

    /**
     * returns the list of associatedParts ObservableList
     */
    public ObservableList<Part> getAllAssociatedParts(){
        return associatedParts;
    }










}
