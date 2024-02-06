package com.example.graphqldemo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Node
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String SIC;
    private String category;
    private String companyNumber;
    private String countryOfOrigin;
    private LocalDate incorporationDate;
    private Integer mortgagesOutstanding;
    private String name;
    private String status;

    private List<Property> owns = new ArrayList<>();

    @Relationship(type = "HAS_CONTROL", direction = Relationship.Direction.INCOMING)
    private List<Person> controlledBy = new ArrayList<>();

    public Company(String SIC,
                   String category,
                   String companyNumber,
                   String countryOfOrigin,
                   LocalDate incorporationDate,
                   Integer mortgagesOutstanding,
                   String name,
                   String status) {
        this.SIC = SIC;
        this.category = category;
        this.companyNumber = companyNumber;
        this.countryOfOrigin = countryOfOrigin;
        this.incorporationDate = incorporationDate;
        this.mortgagesOutstanding = mortgagesOutstanding;
        this.name = name;
        this.status = status;
    }

    public Company withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Company newObject = new Company(this.SIC, this.category, this.companyNumber,
                    this.countryOfOrigin, this.incorporationDate, this.mortgagesOutstanding,
                    this.name, this.status);
            newObject.id = id;
            return newObject;
        }
    }
}
