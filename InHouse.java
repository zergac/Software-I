package com.example.demo2;

public class InHouse extends Part{

    private int machineId;


    /**
     * initializes value to InHouse
     */
    public InHouse(int id, String name, int stock, double price, int min, int max, int machineId){
        super(id, name, stock, price, min, max);
        this.machineId = machineId;
    }

    /**
     * sets value to machineId
     */
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    /**
     * return the machineId value
     */
    public int getMachineId(){
        return machineId;
    }


}
