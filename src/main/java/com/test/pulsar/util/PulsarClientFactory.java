package com.test.pulsar.util;

import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

public class PulsarClientFactory {

    public static PulsarClient getClient() throws PulsarClientException {
        return PulsarClient.builder().serviceUrl("pulsar://localhost:6650").build();
    }
}
