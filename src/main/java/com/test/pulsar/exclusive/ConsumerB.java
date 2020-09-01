package com.test.pulsar.exclusive;

import com.test.pulsar.util.PulsarClientFactory;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

public class ConsumerB {
    public static void main(String[] args) throws PulsarClientException {
        PulsarClient client = PulsarClientFactory.getClient();
        Consumer consumer = client.newConsumer()
                .topic("my-topic")
                .subscriptionName("my-sub")
                .subscribe();

        while (true) {
            Message message = consumer.receive();
            System.out.println(new String(message.getData()));
            consumer.acknowledge(message);
        }
    }

}
