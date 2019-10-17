package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;


public class ScanInformation {

    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

    String model;
    String color;
    int price;
    int count;
    String pressedButton;
    int forCase;
    ArrayList<String> buttins = new ArrayList<String>();

    void getAllInfo() throws IOException {

        setModel();
        setColor();
        setPrice();
        setCount();

    }

    public String setModel() throws IOException {
        System.out.println("-------------------------------------------------");
        System.out.println("Введите модель телефона: ");
        this.model = scan.readLine();
        this.model = model.substring(0, 1).toUpperCase() + model.substring(1).toLowerCase();
        return model;
    }

    public String getModel() {
        return model;
    }

    public String setColor() throws IOException {
        System.out.println("Введите цвет телефона: ");
        this.color = scan.readLine();
        this.color = color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase();
        return color;
    }

    public String getColor() {
        return color;
    }

    public int setPrice() throws IOException {
        System.out.println("Введите цену телефона: ");
        String justNeed = scan.readLine();
        if (isInteger(justNeed)) {
            this.price = Integer.parseInt(justNeed);
            if (price < 1) {
                System.out.println("Количество не может быть меньше 1.");
                setPrice();
            }
        } else {
            setPrice();
        }
        return price;
    }

    public int setCount() throws IOException {
        System.out.println("Введите количество телефонов: ");
        String justNeed = scan.readLine();
        if (isInteger(justNeed)) {
            this.count = Integer.parseInt(justNeed);
            if (count < 1) {
                System.out.println("Количество не может быть меньше 1.");
                setCount();
            }
        } else {
            setCount();
        }
        return count;
    }

    boolean isInteger(String string) {
        try {
            Integer.valueOf(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Введите число");
            return false;
        }
    }

    int getMethod() throws IOException {
        System.out.println("| -New Product- | -Stock- | -Purchase- | -Sale Report- | -Quit- |");
        pressedButton = scan.readLine().toLowerCase();
        buttins.add("new product");
        buttins.add("stock");
        buttins.add("purchase");
        buttins.add("sale report");
        buttins.add("quit");
        for (int i = 0; i < buttins.size(); i++) {
            if (buttins.get(i).equals(pressedButton)){
                forCase = buttins.indexOf(pressedButton)+1;
                return forCase;
            }

        }
        getMethod();
return forCase;
    }
}