package com.example.graphqldemo.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class GraphQLConfig {

    private static final Logger logger = LoggerFactory.getLogger("graphql");

    @Bean
    public GraphQlSourceBuilderCustomizer sourceBuilderCustomizer() {

        return builder ->
                builder.inspectSchemaMappings(schemaReport -> {
                    logger.debug(schemaReport.toString());
                });
    }
}
