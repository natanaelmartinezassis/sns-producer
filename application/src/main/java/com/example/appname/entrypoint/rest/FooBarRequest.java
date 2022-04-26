package com.example.appname.entrypoint.rest;

import com.example.appname.model.FooBar;
import lombok.Getter;

@Getter
public class FooBarRequest {

    private String foo;
    private String bar;
    private double value;

    public FooBar toDomain() {
        return FooBar.builder()
                .foo(this.getFoo())
                .bar(this.getBar())
                .value(this.getValue())
                .build();
    }

}
