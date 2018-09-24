package com.uniovi.quizapp.config;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;

@Configuration
public class MorphiaAutoConfiguration {

    @Autowired
    private MongoClient mongoClient; // created from MongoAutoConfiguration

    @Bean
    public Datastore datastore() {
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.prueba.demo.model");
        morphia.mapPackage("com.prueba.demo.model.question");

        return morphia.createDatastore(mongoClient, "prueba"); // "dataStoreInstanceId" may come from properties?
    }
}
