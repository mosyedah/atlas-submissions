package com.example;

import com.config.DynamoDBConfig;

import java.util.List;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;

public class Day36_Task1 {
	static DynamoDbClient client = DynamoDBConfig.getClient();
	public static void main(String[] args) {
		ListTablesRequest request = ListTablesRequest.builder()
				.build();
		ListTablesResponse response = client.listTables(request);
		
		List<String> tables = response.tableNames();
		
		if (tables.isEmpty()) {
			System.out.println("no tables");
			
		}else {
			tables.forEach(System.out::println);
		}
		
	
	}
}
