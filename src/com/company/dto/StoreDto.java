package com.company.dto;

public class StoreDto {             //  в магазинах инфа о продажах

    private String name;          //    название проданного товара
    private BuyingDto[] sells;    // цифры проданного товара

    public StoreDto(String name, BuyingDto[] sells) {
        this.name = name;
        this.sells = sells;
    }

    public String getName() {
        return name;
    }

    public BuyingDto[] getSells() {
        return sells;
    }
}
