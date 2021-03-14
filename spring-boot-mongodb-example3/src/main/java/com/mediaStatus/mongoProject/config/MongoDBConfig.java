package com.mediaStatus.mongoProject.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(basePackages = "com.mediaStatus.mongoProject")
public class MongoDBConfig {

    @Value("${mongodb.host}")
    private String host;

    @Value("${mongodb.port}")
    private Integer port;

    @Value("${mongodb.database}")
    private String db;

//    @Value("${dynamic.object.mongo.password}")
//    private String password;
//
//    @Value("${dynamic.object.mongo.authenticationDb}")
//    private String authenticationDb;
//
//    @Value("${dynamic.object.mongo.userName}")
//    private String userName;

    public String getDatabaseName() {
        return db;
    }

    @Bean(name = "mongoClient")
    public MongoClient mongoClient() {
//        MongoCredential mongoCredential = createCredential(userName, authenticationDb, password.toCharArray());
        ServerAddress address = new ServerAddress(host, port);
        MongoClientOptions mongoClientOptions = MongoClientOptions.builder().applicationName("mediastatus").build();
        MongoClient client = new MongoClient(address, mongoClientOptions);
        return client;
    }

    @Bean(name = "mongoDbFactory")
    public MongoDbFactory mongoDbFactory() {
        MongoDbFactory factory = new SimpleMongoDbFactory(mongoClient(), getDatabaseName());
        return factory;
    }

    @Bean(name = "statusMongoTemplate")
    public MongoTemplate mongoTemplate() {
        MongoTemplate template = new MongoTemplate(mongoDbFactory(), getDefaultMongoConverter(mongoDbFactory()));
        return template;
    }

    private static MongoConverter getDefaultMongoConverter(MongoDbFactory factory) {
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(factory), new MongoMappingContext());
        converter.setMapKeyDotReplacement("#");
        converter.afterPropertiesSet();
        return converter;
    }
}