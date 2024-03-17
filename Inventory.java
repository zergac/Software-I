package com.example.demo2;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Inventory {
    private ObservableList<Part> allParts;
    private ObservableList<Product> allProducts;


    /**
     * adds a part value to the ObservableList of parts
     */
    public void addPart (Part newPart){
        allParts.add(newPart);
    }

    /**
     * adds a product value to the ObservableList of products
     */
    public void addProduct (Product newProduct){
        allProducts.add(newProduct);
    }

    /**
     * returns a specific part on the ObservableList of parts
     */
    public Part lookupPart (int partID){
        Part p = allParts.get(0);
        for (int i = 0; 0 < allParts.size(); i++){
            p = allParts.get(i);
            if (partID == p.getId()){
                return p;
            }
        }
        return p;
    }

    /**
     * returns a specific product on the ObservableList of products
     */
    public Product lookupProduct (int productID){
        Product p = allProducts.get(0);
        for (int i = 0; i < allProducts.size(); i++){
            p = allProducts.get(i);
            if (productID == p.getId()){
                return p;
            }
        }
        return p;
    }

    /**
     * returns a specific part on the ObservableList of parts
     */
    public ObservableList<Part> lookupPart (String partName){
        ObservableList<Part> list = FXCollections.observableArrayList();
        for (int i = 0; i < allParts.size(); i++){
            Part p = allParts.get(i);
            if (partName.equals(p.getName())){
                list.add(p);
            }
        }
        return list;
    }

    /**
     * returns a specific product on the ObservableList of products
     */
    public ObservableList<Product> lookupProduct (String productName){
        ObservableList<Product> list = FXCollections.observableArrayList();
        for (int i = 0; i < allProducts.size(); i++){
            Product p = allProducts.get(i);
            if (productName.equals(p.getName())){
                list.add(p);
            }
        }
        return list;
    }

    /**
     * sets value to a specific part
     */
    public void updatePart (int index, Part selectedPart){
        allParts.set(index, selectedPart);
    }

    /**
     * sets value to a specific product
     */
    public void updateProduct (int index, Product newProduct){
        allProducts.set(index, newProduct);
    }

    /**
     * returns true if part is available to delete and deletes that part, returns false if there is no part to delete
     */
    public boolean deletePart (Part selectedPart){
        ObservableList<Part> list =  FXCollections.observableArrayList();
        for (int i = 0; i < allParts.size(); i++){
            Part p = allParts.get(i);
            if (selectedPart.getId() != p.getId()){
                list.add(p);
            }
        }
        if (list.size() == allParts.size()){
            return false;
        }
        allParts = list;
        return true;
    }

    /**
     * returns true if product is available to delete and deletes that part, returns false if there is no product to delete
     */
    public boolean deleteProduct (Product selectedProduct){
        ObservableList<Product> list =  FXCollections.observableArrayList();
        for (int i = 0; i < allProducts.size(); i++){
            Product p = allProducts.get(i);
            if (selectedProduct.getId() != p.getId()){
                list.add(p);
            }
        }
        if (list.size() == allProducts.size()){
            return false;
        }
        allProducts = list;
        return true;
    }

    /**
     * returns all the values in ObservableList of Parts
     */
    public ObservableList<Part> getAllParts(){
        return allParts;
    }

    /**
     * returns all the values in ObservableList of Products
     */
    public ObservableList<Product> getAllProducts() {
        return allProducts;
    }




}
