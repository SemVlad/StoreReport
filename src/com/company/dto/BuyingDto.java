package com.company.dto;

public class BuyingDto {

    private String name;   // название товара
    private int count;      // количество товара
    private double sum;        // сумма продажи


    public BuyingDto(String name, int count, double sum) {
        this.name = name;
        this.count = count;
        this.sum = sum;
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

}
