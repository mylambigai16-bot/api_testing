package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get2 {
  @Test
  public void getpractice2test() {
	  
	  Response response = RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts/1");
	  
	  System.out.println("Status Code:"+response.getStatusCode());
	  
	  response.prettyPrint();
	  
	  Assert.assertEquals(response.getStatusCode(),200);
	  
	  System.out.println(response.getHeader("content-Type"));
	  
	  System.out.println(response.getHeaders());
	  
  }
}