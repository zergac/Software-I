package com.example.demo2;

public class Outsourced extends Part {

    private String companyName;


    /**
     * initializes outsourced value
     */
    public Outsourced(int id, String name, int stock, double price, int min, int max, String companyName) {
        super(id, name, stock, price, min, max);
        this.companyName = companyName;
    }

    /**
     * sets company value
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * returns company value
     */
    public String getCompanyName(){
        return companyName;
    }







}
