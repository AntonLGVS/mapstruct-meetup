package com.example.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@AllArgsConstructor
@FieldNameConstants // Not work for MapStruct
public class Model {
    private String a;
    private Integer b;
    private Model2 model2;

    //Custom getter
    public String getA() {
        return a + b;
    }
}

