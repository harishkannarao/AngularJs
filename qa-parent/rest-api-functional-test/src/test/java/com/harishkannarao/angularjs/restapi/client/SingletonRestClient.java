package com.harishkannarao.angularjs.restapi.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.net.ssl.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.function.Supplier;

public class SingletonRestClient {

    private static synchronized Client createAndCacheRestClient() {
        class RestClientFactory implements Supplier<Client> {

            private final Client restClientInstance;

            public RestClientFactory() {
                SSLContext sslcontext = null;
                try {
                    sslcontext = SSLContext.getInstance("TLS");
                    sslcontext.init(null, new TrustManager[]{
                            new X509ExtendedTrustManager() {
                                @Override
                                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                                }
                                @Override
                                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                                }
                                @Override
                                public X509Certificate[] getAcceptedIssuers() {
                                    return null;
                                }
                                @Override
                                public void checkClientTrusted(X509Certificate[] x509Certificates, String s, Socket socket) throws CertificateException {
                                }
                                @Override
                                public void checkServerTrusted(X509Certificate[] x509Certificates, String s, Socket socket) throws CertificateException {
                                }
                                @Override
                                public void checkClientTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) throws CertificateException {
                                }
                                @Override
                                public void checkServerTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) throws CertificateException {
                                }
                            }
                    }, new java.security.SecureRandom());
                    HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());
                }catch (Exception e) {throw new RuntimeException(e);}

                JacksonJsonProvider jacksonJsonProvider = new JacksonJaxbJsonProvider().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                restClientInstance = ClientBuilder.newBuilder().sslContext(sslcontext).hostnameVerifier((s1, s2) -> true).build().register(jacksonJsonProvider);
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
