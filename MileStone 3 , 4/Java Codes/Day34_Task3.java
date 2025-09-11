package com.example;


import com.config.DynamoDBConfig;

import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.services.dynamodb.*;


public class Day34_Task3 {
    public static void main(String[] args) {
        DynamoDbClient dynamoDb = DynamoDBConfig.getClient();

        
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDb)
                .build();

        
        DynamoDbTable<User> userTable = enhancedClient.table("User",
                TableSchema.fromBean(User.class));

       
        User newUser = new User();
        newUser.setUserId("u1");
        newUser.setEmail("u1@example.com");
        newUser.setName("Hamza");
        newUser.setAge(25);

        
        userTable.putItem(newUser);
        System.out.println("Inserted user: " + newUser.getName());

        
        User fetched = userTable.getItem(r -> r.key(
                Key.builder()
                        .partitionValue("u1")
                        .build()
        ));
        System.out.println("Fetched user: " + fetched.getName());

        fetched.setAge(26);
        userTable.updateItem(fetched);
        System.out.println("Updated user age to " + fetched.getAge());

//        userTable.deleteItem(fetched);
//        System.out.println("Deleted user " + fetched.getUserId());

        dynamoDb.close();
    }
}
