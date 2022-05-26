package com.company.service;

import com.company.dto.BuyingDto;
import com.company.dto.ReportDto;
import com.company.dto.ReportMaxDto;
import com.company.dto.StoreDto;
import com.company.model.Store;
import com.company.model.product.Buying;

public class ReportService {

    public static final String SUMMARY_REPORT = "Summary report";

    private Store[] stores;

    public ReportService(Store[] stores) {
        this.stores = stores;
    }

    public ReportDto build() {
        StoreDto[] storeDtos = mapStores();
        BuyingDto[] buyingDtos = mergeBuyings(storeDtos);
        double totalSum = 0;
        for (BuyingDto buyingDto : buyingDtos) {
            totalSum += buyingDto.getSum();
        }
        return new ReportDto(SUMMARY_REPORT, buyingDtos, totalSum);
    }

    public ReportMaxDto buildMax() {
        StoreDto[] storeDtos = mapStores();
        BuyingDto[] buyingDtos = mergeBuyings(storeDtos);
        bubbleSort(buyingDtos);

        return new ReportMaxDto(SUMMARY_REPORT, buyingDtos);
    }

    private BuyingDto[] mergeBuyings(StoreDto[] storeDtos) {

        int count = getCount(storeDtos);
        BuyingDto[] totalArr = new BuyingDto[count];
        int i = 0;
        for (StoreDto storeDto : storeDtos) {
            for (BuyingDto sell : storeDto.getSells()) {
                totalArr[i++] = sell;
            }
        }
        return totalArr;
    }

    //сортируем продажи
    public void bubbleSort(BuyingDto[] buyingDtos) {
        boolean swapped = true;
        int j = 0;
        BuyingDto tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < buyingDtos.length - j; i++) {
                if (buyingDtos[i].getCount() < buyingDtos[i + 1].getCount()) {
                    tmp = buyingDtos[i];
                    buyingDtos[i] = buyingDtos[i + 1];
                    buyingDtos[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    private int getCount(StoreDto[] storeDtos) {
        int count = 0;
        for (StoreDto storeDto : storeDtos) {
            count += storeDto.getSells().length;
        }
        return count;
    }

    private StoreDto[] mapStores() {
        StoreDto[] array = new StoreDto[stores.length];
        for (int i = 0; i < array.length; i++) {
            Store store = stores[i];
            String name = store.getName();
            BuyingDto[] buyingDtos = new BuyingDto[store.getSales().length];
            for (int j = 0; j < store.getSales().length; j++) {
                Buying sale = store.getSales()[j];
                double sum = sale.getProduct().getCost() * sale.getCount();
                buyingDtos[j] = new BuyingDto(sale.getProduct().getName(), sale.getCount(), sum);
            }
            array[i] = new StoreDto(name, buyingDtos);
        }
        return array;
    }
}

