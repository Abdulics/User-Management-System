package com.dultek.ums.service;

import com.dultek.ums.model.Report;

import java.util.List;

public interface ReportingService {
    List<Report> viewAllReports();
    void makeShiftReport();
    public void viewReports();

}
