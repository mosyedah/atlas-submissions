package com.example;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;
import software.amazon.awssdk.services.dynamodb.model.PutRequest;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;
import software.amazon.awssdk.services.dynamodb.model.WriteRequest;

public class Day34_Task2 {
	static DynamoDbClient client = DynamoDbClient.builder()
			.endpointOverride(URI.create("http://localhost:8000"))
			.region(Region.AF_SOUTH_1)
			.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("dummy", "dummy")))
			.build();
	static String table_name = "Products";
	
	public static void main(String[] args) {
//		createTable();
		populate();
	}
	
	private static void createTable() {
		CreateTableRequest request = CreateTableRequest.builder()
				.tableName(table_name)
				.keySchema(KeySchemaElement.builder()
						.keyType(KeyType.HASH)
						.attributeName("productId")
						.build()
						)
				.attributeDefinitions(AttributeDefinition.builder()
						.attributeName("productId")
						.attributeType(ScalarAttributeType.S)
						.build()
						)
				.provisionedThroughput(ProvisionedThroughput.builder()
						.readCapacityUnits(5L)
						.writeCapacityUnits(5L)
						.build()
						)
				.build();
		try {
			client.createTable(request);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void populate() {
		Map<String, AttributeValue> item1 = new HashMap<String, AttributeValue>();
		Map<String, AttributeValue> item2 = new HashMap<String, AttributeValue>();
		
		item1.put("productId", AttributeValue.builder().s("p01").build());
		item2.put("productId", AttributeValue.builder().s("p02").build());
		
		item1.put("name", AttributeValue.builder().s("apple").build());
		item2.put("name", AttributeValue.builder().s("banana").build());
	
		WriteRequest request = WriteRequest.builder()
				.putRequest(PutRequest.builder().item(item1).build()).build();
		WriteRequest request2 = WriteRequest.builder()
				.putRequest(PutRequest.builder().item(item2).build()).build();
		
		BatchWriteItemRequest batchWriteItemRequest = BatchWriteItemRequest.builder()
				.requestItems(Map.of(
						table_name, Arrays.asList(request,request2)
						))
				.build();
		
		try {
			client.batchWriteItem(batchWriteItemRequest);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
