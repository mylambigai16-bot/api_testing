package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetOption {
  @Test
  public void getOption() {
	  
	  
      Response response = RestAssured
    		  .given()
    		  .when()
    		  .options("http://localhost:3000/trainees");
	  
	  System.out.println("Status Code:"+response.getStatusCode());
	  
	  Assert.assertEquals(response.getStatusCode(),204);
  }
}
