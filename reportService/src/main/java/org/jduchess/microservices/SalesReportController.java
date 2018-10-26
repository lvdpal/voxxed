package org.jduchess.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SalesReportController {
    @Autowired
    private SalesReportRepository salesReportRepository;

    @RequestMapping("/getById")
    public Optional<SalesReport> getSalesReport(Long id) {
        return salesReportRepository.findById(id);
    }

    @RequestMapping("/add")
    public void addSalesReport(SalesReport salesReport) {
        salesReportRepository.save(salesReport);
    }


}
