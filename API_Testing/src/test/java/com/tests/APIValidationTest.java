package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class APIValidationTest {
  @Test
  public void apiValidation() {
	  
	  String email = RestAssured
			  .given()
			  .when()
			  .get("https://jsonplaceholder.typicode.com/users/1")
			  .jsonPath()
			  .getString("email");
	  
	  System.out.println("email: "+ email );
	  
	  Assert.assertEquals(email, "Sincere@april.biz");
  }
}
