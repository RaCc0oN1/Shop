package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {

    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Phone> list = new ArrayList<Phone>();
    ArrayList<Phone> cart = new ArrayList<Phone>();
    ScanInformation info = new ScanInformation();

    int stock = 0;// склад пустой

    boolean getterModelEquals;
    boolean getterColorEquals;
    int getterPosI;
    int getterCount;
    int allPrice;
    String getterSelectedModel;
    String getterColor;
    String again;


    public void newProduct(String model) throws IOException {

        if (stock == 0) { // проверка продуктов на складе, если их нет, то создаем новый продукт
            list.add(new Phone(model, info.setColor(), info.setPrice(), info.setCount()));
            stock++;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).model.equals(model)) { // проверка модели на складе
                    getterModelEquals = true;
                    getterPosI = i;  // позиция в листе
                    if (list.get(i).color.equals(info.setColor())) { // проверка цвета, если модель совпала, на складе
                        getterColor = list.get(i).color;
                        getterColorEquals = true;
                    } else {
                        getterColor = info.getColor();
                        getterColorEquals = false;
                    }
                }
            }
            if (getterModelEquals) { // проверка модели
                if (getterColorEquals) { // проверка цвета
                    System.out.println("На складе в данный момент телефон " + list.get(getterPosI).model + " с цветом " + list.get(getterPosI).color + " в количестве:" + list.get(getterPosI).count + "\nКакое кол-во телефонов добавить на склад?");
                    list.get(getterPosI).addCount(info.setCount());
//                    System.out.println("Модель и цвет телефона совпали с продуктом на складе. \n Добавление количество прихода....\n");
                } else {
                    list.add(new Phone(model, getterColor, info.setPrice(), info.setCount()));
                }
            } else {
                list.add(new Phone(model, info.setColor(), info.setPrice(), info.setCount()));
            }

        }
    }

    void printerStock() {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------СКЛАД----------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Модель телефона: " + list.get(i).model + ";\nЦвет телефона: " + list.get(i).color + ";\nКоличество телефонов на складе: " + list.get(i).count + ";\nЦена одного телефона: " + list.get(i).price + ";");
            System.out.println("-------------------------------------------------");
        }
        System.out.println("----------------------------------------СКЛАД----------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public void purchase(String model) throws IOException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).model.equals(model)) { // проверка модели на складе
                getterSelectedModel = list.get(i).model;
                getterModelEquals = true;
                getterPosI = i;  // позиция в листе
                if (list.get(i).color.equals(info.setColor())) { // проверка цвета, если модель совпала, на складе
                    getterColor = list.get(i).color;
                    getterColorEquals = true;
                } else {
                    System.out.println("У нас нет такой расцветки, как " + list.get(i).color + " у телефона " + list.get(i).model + ".\nПопробуйте другую расцветку.\n");
                    getterColorEquals = false;
                    purchase(getterSelectedModel);
                }
            } else {
                System.out.println("Нет такого телефона в нашем магазине, попробуйте другой товар.");
                purchase(info.setModel());
            }
        }
        if (getterModelEquals) { // проверка модели
            if (getterColorEquals) { // проверка цвета

                for (int i = 0; i < cart.size(); i++) {
                    if (cart.get(i).model.equals(model)) { // проверка модели на складе
                        getterSelectedModel = cart.get(i).model;
                        getterModelEquals = true;
                        getterPosI = i;  // позиция в CART
                        if (cart.get(i).color.equals(getterColor)) { // проверка цвета, если модель совпала, на складе
                            getterColor = cart.get(i).color;
                            getterColorEquals = true;
                        } else {
                            getterColorEquals = false;
                            purchase(getterSelectedModel);
                        }
                    } else {
                        System.out.println("Нет такого телефона в нашем магазине, попробуйте другой товар.");
                        purchase(info.setModel());
                    }
                }
                if (getterModelEquals) { // проверка модели
                    if (getterColorEquals) { // проверка цвета
                        System.out.println("На складе в данный момент телефон " + list.get(getterPosI).model + " с цветом " + list.get(getterPosI).color + " в количестве:" + list.get(getterPosI).count + "\nКакое кол-во телефонов добавить в заказ?");
                        getterCount = info.setCount();
                        list.get(getterPosI).removeCount(getterCount);
                        allPrice = allPrice + getterCount * list.get(getterPosI).price;
                        cart.add(list.get(getterPosI));
                    }

                }
            }

        }


/*        System.out.println("Вы хотите продолжить покупки? [Y|N]");
        again = scan.readLine().toLowerCase();
        if (again == "y" || again == "yes") {
            purchase(info.setModel());
        } else if (again == "n" || again == "no") {
            breaker();
        }*/
    }

    public void printerBuyScore() {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------ЧЕК----------------------------------------");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println("Модель телефона: " + cart.get(i).model + ";\nЦвет телефона: " + cart.get(i).color + ";\nКоличество телефонов было куплено: " + cart.get(i).count + ";" + "\n\n");
        }
        System.out.println("Общая сумма за смену: " + allPrice);
        System.out.println("----------------------------------------ЧЕК----------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
    }


    public void breaker() {

    }

}
