package com.example.appname.gateway.message.support;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class GenericMessage<T> implements Serializable {

    private final String traceId;
    private final String spanId;
    private final T message;

}
