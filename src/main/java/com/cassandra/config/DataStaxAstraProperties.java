package com.cassandra.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

@Data
@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraProperties {

    private File secureConnectCassandra;

    public DataStaxAstraProperties() throws IOException {
        // Load the resource using Spring's ClassPathResource which handles classpath resources
        Resource resource = new ClassPathResource("secure-connect-cassandra.zip");

        // Get the File from the resource
        secureConnectCassandra = resource.getFile();
    }
}
