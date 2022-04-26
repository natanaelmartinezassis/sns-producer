package com.example.appname.model;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public class Header {
    private final Map<String, Object> headers;

    private Header(Builder builder) {
        this.headers = builder.headers;
    }

    public static class Builder {

        private final Map<String, Object> headers;

        public Builder() {
            headers = new HashMap<>();
        }

        public Builder addHeader(final String key, final Object value) {
            this.headers.put(key, value);
            return this;
        }

        public Header build() {
            return new Header(this);
        }
    }
}
