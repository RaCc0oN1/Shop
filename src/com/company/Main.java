package com.company;

import java.io.IOException;


public class Main {


    public void main() throws IOException {



        Shop shop = new Shop();
        ScanInformation info = new ScanInformation();
boolean smth = true;
while (smth)
        switch (info.getMethod()) {
            case 1:
                shop.newProduct(info.setModel());
                break;
            case 2:
                shop.printerStock();
                break;
            case 3:
                shop.purchase(info.setModel());
                break;
            case 4:
                shop.printerBuyScore();
                break;
            case 5:
                smth = false;
                break;
        }


    }


}
