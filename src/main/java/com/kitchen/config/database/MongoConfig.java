package com.kitchen.config.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.kitchen.model.ModelPackage;
import com.kitchen.repository.RepositoryPackage;
import com.kitchen.util.StaticContent;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
@EnableMongoRepositories(basePackageClasses = RepositoryPackage.class)
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return StaticContent.DB_NAME;
	}

	@Override
	@Bean
	public MongoClient mongo() throws Exception {
		MongoClient client = new MongoClient(StaticContent.MONGO_CLIENT);
		client.setWriteConcern(WriteConcern.SAFE);
		return client;
	}

	@Override
	protected String getMappingBasePackage() {
		return ModelPackage.class.getPackage().toString();
	}

	@Bean
	@Override
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), getDatabaseName());
	}
}