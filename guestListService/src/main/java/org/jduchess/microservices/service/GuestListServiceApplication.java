package org.jduchess.microservices.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "org.jduchess.microservices.domain")
public class GuestListServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuestListServiceApplication.class);
    }
}
