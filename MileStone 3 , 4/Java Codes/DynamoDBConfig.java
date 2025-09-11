package com.config;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import java.net.URI;

public class DynamoDBConfig {
	private static DynamoDbClient instance;
	
	private DynamoDBConfig() {
		
	}
	
	public static synchronized DynamoDbClient getClient() {
		if(instance == null) {
			instance = DynamoDbClient.builder()
					.endpointOverride(URI.create("http://localhost:8000"))
					.region(Region.US_EAST_1)
					.credentialsProvider(StaticCredentialsProvider.create(
							AwsBasicCredentials.create("dummy", "dummy")))
					.build();
		}
		return instance;
	}
}	
