package com.harishkannarao.angularjs.restapi.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.function.Supplier;

public class SingletonRestClient {

    private static synchronized Client createAndCacheRestClient() {
        class RestClientFactory implements Supplier<Client> {

            private final Client restClientInstance;

            public RestClientFactory() {
                JacksonJsonProvider jacksonJsonProvider = new JacksonJaxbJsonProvider().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                restClientInstance = ClientBuilder.newClient().register(jacksonJsonProvider);
                Runtime.getRuntime().addShutdownHook(new Thread("Rest client shutdown thread") {
                    public void run() {
                        restClientInstance.close();
                    }
                });
            }

            @Override
            public Client get() {
                return restClientInstance;
            }
        }

        if(!RestClientFactory.class.isInstance(clientSupplier)) {
            clientSupplier = new RestClientFactory();
        }
        return clientSupplier.get();
    }

    private static Supplier<Client> clientSupplier = SingletonRestClient::createAndCacheRestClient;

    public static Client getInstance() {
        return clientSupplier.get();
    }
}
