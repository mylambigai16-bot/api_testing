package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUserTest {
  @Test
  public void createUser() {
	  
	  Map<String, Object> payload = new HashMap<>();
	  payload.put("title", "My first post");
	  payload.put("body","Learning Rest Assured");
	  payload.put("userId",1);
	  
	  Response response = RestAssured
			  .given()
			  .contentType(ContentType.JSON)
			  .body(payload)
			  .when()
			  .post("https://jsonplaceholder.typicode.com/posts");
	  
	  System.out.println("Statuc code: "+response.getStatusCode());
	  Assert.assertEquals(response.getStatusCode(), 201);
	  
  }
}
