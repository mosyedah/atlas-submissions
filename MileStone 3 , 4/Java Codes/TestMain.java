package com.example;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class TestMain {
	private static final String tableName  = "Students";
	private static DynamoDbClient instance = DynamoDbClient.builder()
			.endpointOverride(URI.create("https://dynamodb.ap-south-1.amazonaws.com")).region(Region.AP_SOUTH_1)
			.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(" revoked ", " revoked")))
			.build();

	public static void main(String[] args) {
		 try {
	            ListTablesResponse response = instance.listTables(ListTablesRequest.builder().limit(5).build());
	            System.out.println("Connection successful! Tables found: " + response.tableNames());
//	            createTable();
//	            insert("UUIDEX1", "John Doe");
//	            retrive("UUIDEX1");
//	            update("UUIDEX1", "Alice");
//	            insert("UUIDEX2", "Alex K");
//	            delete("UUIDEX2");
	            
	        } catch (Exception e) {
	            System.err.println("Failed to connect to DynamoDB: " + e.getMessage());
	        } finally {
	            instance.close();
	        }
		 
	}
	
	private static void createTable() {
		try {
			KeySchemaElement key = KeySchemaElement.builder()
					.keyType(KeyType.HASH)
					.attributeName("ID")
					.build();
			
			CreateTableRequest createTableRequest = CreateTableRequest.builder()
					.tableName("Students")
					.keySchema(key)
					.attributeDefinitions(AttributeDefinition.builder().attributeName("ID").attributeType(ScalarAttributeType.S).build())
					.provisionedThroughput(ProvisionedThroughput.builder().readCapacityUnits(5L).writeCapacityUnits(5L).build())
					.build();
			
			CreateTableResponse createTableResponse = instance.createTable(createTableRequest);
			System.out.println(createTableResponse.tableDescription().tableName()+" table is created");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void insert(String id, String name) {
		try {
			HashMap<String, AttributeValue> item = new HashMap<String, AttributeValue>();
			item.put("ID", AttributeValue.builder().s(id).build());
			item.put("name", AttributeValue.builder().s(name).build());
			
			PutItemRequest putItemRequest = PutItemRequest.builder()
					.tableName(tableName)
					.item(item)
					.build();
			
			PutItemResponse putItemResponse = instance.putItem(putItemRequest);
			
			System.out.println("Item Inserted Successfully");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void retrive(String id) {
		try {
			HashMap<String, AttributeValue> key = new HashMap<String, AttributeValue>();
			key.put("ID", AttributeValue.builder().s(id).build());
			
			GetItemRequest getItemRequest = GetItemRequest.builder()
					.key(key)
					.tableName(tableName)
					.build();
			GetItemResponse getItemResponse = instance.getItem(getItemRequest);
			
			if (getItemResponse.hasItem()) {
				Map<String, AttributeValue> item = getItemResponse.item();
				System.out.println("name for Id : "+ id +" is : "+ item.get("name").s());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void update(String id, String newName) {
		try {
			HashMap<String, AttributeValue> key = new HashMap<String, AttributeValue>();
			key.put("ID", AttributeValue.builder().s(id).build());
			
			HashMap<String, String> expressionNames = new HashMap<String, String>();
			expressionNames.put("#N" , "name");
			
			HashMap<String, AttributeValue> values = new HashMap<>();
			values.put(":name", AttributeValue.builder().s(newName).build());
			
			UpdateItemRequest request = UpdateItemRequest.builder()
					.tableName(tableName)
					.key(key)
					.updateExpression("set #N = :name")
					.expressionAttributeNames(expressionNames)
					.expressionAttributeValues(values)
					.build();
			
			UpdateItemResponse response = instance.updateItem(request);
			System.out.println("Item Updated successfully");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	private static void delete(String id) {
		try {
			HashMap<String, AttributeValue> item = new  HashMap<String, AttributeValue>();
			
			item.put("ID" , AttributeValue.builder().s(id).build());
			
			DeleteItemRequest request = DeleteItemRequest.builder()
					.key(item)
					.tableName(tableName)
					.build();
			
			instance.deleteItem(request);
			System.out.println("Item with ID : "+ id + "Deleted successfully");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
