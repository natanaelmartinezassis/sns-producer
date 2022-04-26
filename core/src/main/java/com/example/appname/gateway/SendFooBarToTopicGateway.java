package com.example.appname.gateway;

public interface SendFooBarToTopicGateway {

    <T> void execute(final T fooBar);

}
