package com.test.pulsar.exclusive;

import com.test.pulsar.util.PulsarClientFactory;
import org.apache.pulsar.client.api.*;

public class ConsumerA {
    public static void main(String[] args) throws PulsarClientException {
        PulsarClient client = PulsarClientFactory.getClient();
        Consumer consumer = client.newConsumer()
                .topic("my-topic")
                .subscriptionType(SubscriptionType.Exclusive) //默认Exclusive，没有这句也一样是Exclusive
                .subscriptionName("my-sub")
                .subscribe();

        while (true) {
            Message message = consumer.receive();
            System.out.println(new String(message.getData()));
            consumer.acknowledge(message);
        }
    }

}
