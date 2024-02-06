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
public class Property {
    @Id
    @GeneratedValue
    private Long id;
    private String address;
    private String county;
    private String district;
    private String titleNumber;

    public Property(String address, String county, String district, String titleNumber) {
        this.address = address;
        this.county = county;
        this.district = district;
        this.titleNumber = titleNumber;
    }

    public Property withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Property newObject = new Property(this.address, this.county, this.district, this.titleNumber);
            newObject.id = id;
            return newObject;
        }
    }
}
