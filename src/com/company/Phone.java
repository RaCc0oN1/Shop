package com.company;

public class Phone {

    String model;
    int price;
    int count;
    String color;

    Phone(String model, String color, int price, int count) {
        this.model = model;
        this.price = price;
        this.count = count;
        this.color = color;
    }

   public String getModel(){
        return model;
    }

    int getPrice(){
        return price;
    }

    int getCount(){
        return count;
    }

    void addCount(int count){
        this.count = this.count + count;
    }
    void removeCount(int count){
        this.count = this.count - count;
    }
    String getColor(){
        return color;
    }




}
