package com.pfeffer.anotaaicatalog.services;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import com.pfeffer.anotaaicatalog.core.MessageDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AwsSnsService {

    @Qualifier("catalogEventsTopic")
    private final Topic catalogEventsTopic;

    private final AmazonSNS snsClient;

    public AwsSnsService(AmazonSNS snsClient, Topic catalogEventsTopic) {
        this.snsClient = snsClient;
        this.catalogEventsTopic = catalogEventsTopic;
    }

    public void publish(MessageDTO message) {
        this.snsClient.publish(catalogEventsTopic.getTopicArn(), message.message());
    }

}
