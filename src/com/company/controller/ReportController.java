package com.company.controller;

import com.company.dto.BuyingDto;
import com.company.dto.ReportDto;
import com.company.dto.ReportMaxDto;
import com.company.dto.StoreDto;
import com.company.model.Store;
import com.company.model.product.Buying;
import com.company.service.ReportService;
import com.company.view.ReportMaxView;
import com.company.view.ReportView;

public class ReportController {


    public void exec(Store[] stores) {
        ReportService reportService = new ReportService(stores);
        ReportMaxView viewMax = new ReportMaxView();  // раелизовуем класс

        ReportMaxDto reportMax = reportService.buildMax();   //
        viewMax.printReportMax(reportMax);
    }

    public void execute(Store[] stores) {

        ReportService reportService = new ReportService(stores);
        ReportDto report = reportService.build();
        ReportView view = new ReportView();
        view.printDetails(report);


    }
}
