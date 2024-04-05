package com.pfeffer.anotaaicatalog.infra.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoDBConfig {

    @Value("${MONGODB_URI}")
    private String mongoUri;

    @Bean
    public MongoDatabaseFactory mongoConfigure() {
        return new SimpleMongoClientDatabaseFactory(mongoUri);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoConfigure());
    }

}
