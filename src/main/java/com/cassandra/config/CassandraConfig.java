package com.cassandra.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;

import java.io.IOException;
import java.net.InetSocketAddress;

@Configuration
public class CassandraConfig {

    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Value("${spring.data.cassandra.username}")
    private String username;

    @Value("${spring.data.cassandra.password}")
    private String password;

    @Value("${spring.data.cassandra.local-datacenter}")
    private String localDatacenter;

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspaceName;

    @Bean
    public DataStaxAstraProperties dataStaxAstraProperties() throws IOException {
        return new DataStaxAstraProperties();
    }

    @Bean
    public CqlSession cqlSession(DataStaxAstraProperties astraProperties) {
        CqlSessionBuilder builder = CqlSession.builder()
                .addContactPoint(new InetSocketAddress(contactPoints, port))
                .withCloudSecureConnectBundle(astraProperties.getSecureConnectCassandra().toPath())
                .withAuthCredentials(username, password)
                .withLocalDatacenter(localDatacenter)
                .withKeyspace(keyspaceName);

        return builder.build();
    }
}


