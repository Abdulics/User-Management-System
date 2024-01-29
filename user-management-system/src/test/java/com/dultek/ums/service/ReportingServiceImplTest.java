package com.dultek.ums.service;

import com.dultek.ums.model.Report;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReportingServiceImplTest {

    private ReportingService reportingService = new ReportingServiceImpl();

    @Test
    public void testViewAllReports() {
        List<Report> reports = reportingService.viewAllReports();
        assertNotNull(reports);
        // Add more assertions based on the behavior of the viewAllReports method
    }

    @Test
    public void testMakeShiftReport() {
        assertDoesNotThrow(() -> reportingService.makeShiftReport());
        // Add more assertions based on the behavior of the makeShiftReport method
    }

    @Test
    public void testViewReports() {
        assertDoesNotThrow(() -> reportingService.viewReports());
        // Add more assertions based on the behavior of the viewReports method
    }
}
