package com.company.view;

import com.company.dto.BuyingDto;
import com.company.dto.ReportDto;

public class ReportView {

    public static final String DESCRIPTION = "REPORT DATA:  ";

    public void printDetails(ReportDto report) {
        int dash = 50;
        System.out.println("=".repeat(dash));
        System.out.println(DESCRIPTION + report.getName());
        System.out.println("=".repeat(dash));

        // вывод названий столбцов
        int length = 20; // длинна между колонками с учетом названия  колонки
        int countSpaceName = length - 4;
        System.out.print("name");
        for (int i = 1; i <= countSpaceName; i++) {
            System.out.print(" ");
        }
        System.out.print("");
        System.out.print("count");

        int countSpaceCount = length - 5;
        for (int i = 1; i <= countSpaceCount; i++) {
            System.out.print(" ");
        }
        System.out.print(" ");
        System.out.println("sum");
        System.out.println("=".repeat(dash));

        // вывод значений столбцов
        for (BuyingDto buyingDto : report.getData()) {
            String cost = Math.round(buyingDto.getSum()) + " uah";

            // длинные названия товара делим по признаку и переносим на новый рядок
            int strName = Integer.parseInt(String.valueOf(buyingDto.getName().length()));
            if (strName < length) {
                System.out.print(buyingDto.getName());
            } else {
                String[] str;
                str = buyingDto.getName().split(" ");
                for (int i = 0; i < str.length; i++) {
                    System.out.println(str[i]);
                }
            }

            // вывод значения счетчика
            int countChar = buyingDto.getName().length();// длинна слова
            int indentCount = length - countChar;

            for (int i = 1; i <= indentCount; i++) {
                System.out.print(" ");
            }
            System.out.print(buyingDto.getCount());

            // вывод значения суммы
            String strCount = String.valueOf(buyingDto.getCount());
            int numCount = strCount.length();
            int indentSum = length - numCount;

            for (int i = 1; i <= indentSum; i++) {
                System.out.print(" ");
            }
            System.out.println(buyingDto.getSum() + " uah");
            System.out.println("-".repeat(dash));
        }
        System.out.println("=".repeat(dash));
        System.out.println("Total sum: " + report.getTotalSum() + " uah");

    }
}
