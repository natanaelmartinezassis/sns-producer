package com.example.appname.config.aws.sns;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.example.appname.config.aws.AWSProperty;
import lombok.AllArgsConstructor;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSns;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableSns
@Configuration
@AllArgsConstructor
public class SNSConfig {

    @Bean
    public AmazonSNS amazonSNS(AWSCredentialsProvider credential, AWSProperty awsProperty) {
        return AmazonSNSClient
                .builder()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(awsProperty.getEndpoint(), awsProperty.getRegion()))
                .withCredentials(credential)
                .build();
    }

    @Bean
    public NotificationMessagingTemplate notificationMessagingTemplate(AmazonSNS amazonSNS) {
        return new NotificationMessagingTemplate(amazonSNS);
    }

}
