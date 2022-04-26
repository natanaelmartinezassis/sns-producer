package com.example.appname.gateway.message;

import com.example.appname.gateway.SendFooBarToTopicGateway;
import com.example.appname.gateway.message.support.SendToSNSTopic;
import com.example.appname.model.Header;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendFooBarToTopicProvider implements SendFooBarToTopicGateway {

    private final SendToSNSTopic sendToSNSTopic;

    @Value("${sns.topic.add-foobar}")
    private String topicName;

    @Override
    public <T> void execute(T fooBar) {

        final Header header = new Header.Builder()
                .addHeader("channel", "any-channel-example")
                .build();

        sendToSNSTopic.send(topicName, fooBar, header.getHeaders());

    }

}