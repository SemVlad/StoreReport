package com.company.view;

import com.company.dto.BuyingDto;
import com.company.dto.ReportMaxDto;

public class ReportMaxView {

    public static final String TOPSELLS = "REPORT SALLES: TOP FIVE";

    public void printReportMax(ReportMaxDto reportMax) {
        int dash = 50;
        System.out.println();
        System.out.println("*".repeat(dash));
        System.out.println(TOPSELLS);
        System.out.println("*".repeat(dash));

        int length = 25; // длинна между колонками с учетом названия  колонки
        int countSpaceName = length - 4;
        System.out.print("name");
        for (int i = 1; i <= countSpaceName; i++) {
            System.out.print(" ");
        }
        System.out.print("");
        System.out.print("count");
        System.out.println("");
        System.out.println("-".repeat(dash));

        BuyingDto[] buyingDtos = reportMax.getData();

        for (int i = 0; i < 5; i++) {
            System.out.print(buyingDtos[i].getName());

            // выравниваем в зависимости от длинны названия товара
            int countChar = buyingDtos[i].getName().length();
            int indentCount = length - countChar;
            for (int j = 0; j < indentCount; j++) {
                System.out.print(" ");
            }
            System.out.println(buyingDtos[i].getCount());
            System.out.println("-".repeat(dash));
        }
    }
}

