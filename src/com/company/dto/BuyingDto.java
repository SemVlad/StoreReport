package com.company.dto;

import java.util.Arrays;

public class BuyingDto {

    private String name;   // название товара
    private int count;      // количество товара
    private double sum;        // сумма продажи
    private Arrays[] ar; // массив счетчиков

    public BuyingDto(String name, int count, double sum) {
        this.name = name;
        this.count = count;
        this.sum = sum;
    }

    public BuyingDto() {
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public Arrays[] getAr() {
        return ar;
    }

    public void setAr(Arrays[] ar) {
        this.ar = ar;
    }
}
