package org.jduchess.microservices;

import org.jduchess.microservices.model.SalesReport;
import org.springframework.data.repository.CrudRepository;


public interface SalesReportRepository extends CrudRepository<SalesReport, Long> {
}
