package com.example.graphqldemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String birthMonth;
    private String birthYear;
    private String countryOfResidence;

    private String name;
    private String nationality;

    public Person(String birthMonth, String birthYear, String countryOfResidence, String name, String nationality) {
        this.id = null;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.countryOfResidence = countryOfResidence;
        this.name = name;
        this.nationality = nationality;
    }

    public Person withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Person newObject = new Person(this.birthMonth, this.birthYear, this.countryOfResidence, this.name, this.nationality);
            newObject.id = id;
            return newObject;
        }
    }
}
