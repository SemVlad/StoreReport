package com.company.view;

import com.company.dto.BuyingDto;
import com.company.dto.ReportMaxDto;

public class ReportMaxView {

    public static final String TOPSELLS = "REPORT SALLES:  ";

    public void printReportMax(ReportMaxDto reportMax) {
        int dash = 50;
        System.out.println("*".repeat(dash));
        System.out.println(TOPSELLS + reportMax.getName());
        System.out.println();


        int length = 20; // длинна между колонками с учетом названия  колонки
        int countSpaceName = length - 4;
        System.out.print("name");
        for (int i = 1; i <= countSpaceName; i++) {
            System.out.print(" ");
        }
        System.out.print("");
        System.out.print("count");


        BuyingDto[] buyingDtos = reportMax.getData();

        for (int i = 0; i < 5; i++) {
            System.out.println("название проукта: " + buyingDtos[i].getName());
            System.out.println("");
        }
    }
}
