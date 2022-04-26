package com.example.appname.gateway.message;

import com.example.appname.model.FooBar;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonSerialize
public class FooBarMessage {

    private String clientDocumentNumber;
    private String creditorDocumentNumber;
    private double value;

    public static FooBarMessage fromDomain(final FooBar fooBar) {
        return FooBarMessage.builder()
                .clientDocumentNumber(fooBar.getFoo())
                .creditorDocumentNumber(fooBar.getBar())
                .value(fooBar.getValue())
                .build();
    }

}
