package com.example.graphqldemo.controller;

import com.example.graphqldemo.model.Company;
import com.example.graphqldemo.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@GraphQlTest(CompanyController.class)
class CompanyControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private CompanyRepository companyRepository;

    @Test
    public void getCompanies() {
        when(companyRepository.findAll())
                .thenReturn(Flux.just(new Company(
                        "1234",
                        "private",
                        "12345678",
                        "UK",
                        LocalDate.of(2024, 1, 1),
                        0,
                        "Test Company",
                        "active")));

        graphQlTester
                .documentName("companyList")
                .variable("page", 0)
                .execute()
                .path("companyList")
                .matchesJson("""
                    [{
                        "id": null,
                        "SIC": "1234",
                        "name": "Test Company",
                        "status": "active",
                        "category": "private",
                        "companyNumber": "12345678",
                        "countryOfOrigin": "UK"
                    }]
                """);
    }
}