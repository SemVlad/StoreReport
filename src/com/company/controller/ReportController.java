package com.company.controller;

import com.company.dto.ReportDto;
//import com.company.dto.ReportMaxDto;
//import com.company.dto.StoreDto;
import com.company.model.Store;
import com.company.service.ReportService;
//import com.company.view.ReportMaxView;
import com.company.view.ReportView;

public class ReportController {

    public void execute(Store[] stores) {

        ReportService reportService = new ReportService(stores);
        ReportDto report = reportService.build();

        ReportView view = new ReportView();
        view.printDetails(report);


        // мои каляки
  //      ReportMaxView viewMax = new ReportMaxView();
       // ReportMaxDto repMax = reportService.caunt();   // max getMaxCount
       // viewMax.printRepMax(repMax);

        //ReportDto repMax = reportService.getCount();

    }
}
