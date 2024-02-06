package com.example.graphqldemo.repository;

import com.example.graphqldemo.model.Company;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface CompanyRepository extends ReactiveNeo4jRepository<Company, Long> {
}
