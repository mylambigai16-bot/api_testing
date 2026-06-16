package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTrainee {
  @Test
  public void getTrainee() {
	  
	  
      Response response = RestAssured
    		  .given()
    		  .when()
    		  .get("http://localhost:3000/trainees/BuznQU3HGHE");
	  
	  System.out.println("Status Code:"+response.getStatusCode());
	  System.out.println(response.asPrettyString());
	  System.out.println(response.contentType());
	  System.out.println(response.getContentType());
	  System.out.println(response.statusCode());
	  response.prettyPrint();
	  
	  Assert.assertEquals(response.getStatusCode(),200);
  }
}
