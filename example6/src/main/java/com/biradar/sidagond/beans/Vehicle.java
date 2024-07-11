package com.biradar.sidagond.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Vehicle {

    private String name;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    @Override
    public String toString(){
        return "Vehicle name is - "+name;
    }
}