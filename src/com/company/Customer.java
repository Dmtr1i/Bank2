package com.company;

import java.text.DecimalFormat;

public class Customer {
    private double money;
    private int serviseTime;

    Customer() {
        money = Math.ceil((Math.random() * 500 - 250) * 100) / 100;
        serviseTime = (int)(Math.random() * 10 + 5);
    }

    public double getMoney() {
        return money;
    }

    public int getServiseTime() {
        return serviseTime;
    }
}
