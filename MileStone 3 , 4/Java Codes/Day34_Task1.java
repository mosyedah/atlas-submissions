package com.example;
import java.net.URI;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

public class Day34_Task1 {
	static DynamoDbClient client = DynamoDbClient.builder()
			.endpointOverride(URI.create("http://localhost:8000"))
			.region(Region.AF_SOUTH_1)
			.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("dummy", "dummy")))
			.build();
	static String table_name = "Users";
	
	public static void main(String[] args) {
		ScanRequest request = ScanRequest.builder()
				.tableName(table_name)
				.build();
		
		try {
			ScanResponse response = client.scan(request);
			response.items().forEach(item -> { 
				
				System.out.println(item);
				
			
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
