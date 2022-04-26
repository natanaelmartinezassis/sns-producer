package com.example.appname.gateway.message.support;

import brave.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendToSNSTopic {

    private final NotificationMessagingTemplate messagingTemplate;

    private final Tracer tracer;

    public <T> void send(String topicName, T message, Map<String, Object> headers) {
        try {
            messagingTemplate.convertAndSend(
                    topicName,
                    GenericMessage.builder()
                            .traceId(tracer.currentSpan().context().traceIdString())
                            .spanId(tracer.currentSpan().context().spanIdString())
                            .message(message)
                            .build(),
                    headers
            );
            log.debug("{} sent to SNS topic {}",
                    kv("sns_notification", message),
                    kv("sns_topic", topicName));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }

    }
}

