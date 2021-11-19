package com.customdev.customer.api.queue.producer;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Value("${aws.sqs.queue.send.email.name}")
    private String queueName;

    @Autowired
    private AmazonSQS amazonSQS;

    public void sentToQueue(String message) {
        final SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(queueName)
                .withMessageBody(message);

        amazonSQS.sendMessage(sendMessageRequest);
    }
}
