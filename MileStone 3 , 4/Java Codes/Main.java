package com.example;

import java.util.HashMap;
import java.util.Map;

import com.config.DynamoDBConfig;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

public class Main {
	private static DynamoDbClient ddb = DynamoDBConfig.getClient();
	public static void main(String[] args) {
		if (!isTableExist("Users")) {
			if(createUsersTable()) 
				System.out.println("table created");			
		}else {
			System.out.println("Users Table already exists");
		}
		
//		addUser("acc21","John");
		fetchUser("acc21");
//		delUser("acc01");
		updateUser("acc21", "newUser");
		
	}

	public static boolean isTableExist(String tableName) {
			try {
				DescribeTableRequest describeRequest = DescribeTableRequest.builder().tableName(tableName).build();
				ddb.describeTable(describeRequest);
				return true;
			} catch (ResourceNotFoundException e) {
				return false;
			}
	}
	
	
	private static boolean createUsersTable() {
		try {
			
			CreateTableRequest request = CreateTableRequest.builder()
					.tableName("Users")
					.keySchema(KeySchemaElement.builder().attributeName("UserId")
							.keyType(KeyType.HASH)
							.build())
					.attributeDefinitions(AttributeDefinition.builder()
							.attributeName("UserId")
							.attributeType(ScalarAttributeType.S)
							.build()
							)
					.provisionedThroughput(ProvisionedThroughput.builder()
							.readCapacityUnits(5L)
							.writeCapacityUnits(5L)
							.build()
							)
					.build();
			ddb.createTable(request);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static boolean addUser(String userId,String name) {
		try {
			
			Map<String, AttributeValue> user = new HashMap<String, AttributeValue>();
			
			user.put("UserId", AttributeValue.builder().s(userId).build());
			user.put("Name", AttributeValue.builder().s(name).build());
			
			PutItemRequest putRequest = PutItemRequest.builder()
					.tableName("Users")
					.item(user)
					.build();
			ddb.putItem(putRequest);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private static void fetchUser(String userId) {
		try {
			Map<String,AttributeValue> user = new HashMap<String, AttributeValue>();
			user.put("UserId", AttributeValue.builder().s(userId).build());
			GetItemRequest request = GetItemRequest.builder()
					.tableName("Users")
					.key(user)
					.build();
			GetItemResponse response = ddb.getItem(request);
			if (response.item().isEmpty()) {
				System.out.println("No user found with User ID : "+ userId);
				return;
			}
			System.out.println(response.item().get("UserId").s());
			System.out.println(response.item().get("Name").s());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void delUser(String userId) {
		try {
			Map<String,AttributeValue> user = new HashMap<String, AttributeValue>();
			user.put("UserId", AttributeValue.builder().s(userId).build());
			DeleteItemRequest request = DeleteItemRequest.builder()
					.tableName("Users")
					.key(user)
					.returnValues(ReturnValue.ALL_OLD) // to see if it is deleted
					.build();
			DeleteItemResponse response =  ddb.deleteItem(request);
			if(response.attributes().isEmpty()) {
				System.out.println("No such user found for deleting : "+ userId);
			}else {
				System.out.println("deleted successfully");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void updateUser(String userId, String newName) {
		Map<String, AttributeValue> user = new HashMap<String, AttributeValue>();
		user.put("UserId", AttributeValue.builder().s(userId).build());
		
		Map<String, AttributeValue> values = new HashMap<String, AttributeValue>();
		values.put(":name", AttributeValue.builder().s(newName).build());
		
		Map<String, String> expressionNames = new HashMap<String, String>();
		expressionNames.put("#N", "Name");
		UpdateItemRequest request = UpdateItemRequest.builder()
				.tableName("Users")
				.key(user)
				.updateExpression("SET #N = :name")
				.expressionAttributeNames(expressionNames)
				.conditionExpression("attribute_exists(UserId)")
				.expressionAttributeValues(values)
				.returnValues(ReturnValue.ALL_NEW)
				.build();
		try {
			UpdateItemResponse response = ddb.updateItem(request);
			
			System.out.println("Updated User :: "+ response.attributes());
		} catch (ConditionalCheckFailedException e) {
			System.out.println("no user found with userId "+ userId);
		}
	}
}
