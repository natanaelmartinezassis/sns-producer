package com.example.appname.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class FooBar {

    private String foo;
    private String bar;
    private double value;

    // any model business rules

}
