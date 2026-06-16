package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateSpecific {
  @Test
  public void update_Trainee() {
	  
	  Map<String, Object> payload = new HashMap<>();
	  payload.put("Name", "Tara");
	  payload.put("email","tara@gmail.com");
	  
      Response response = RestAssured
    		  .given()
    		  .contentType(ContentType.JSON)
    		  .body(payload)
    		  .when()
    		  .patch("http://localhost:3000/trainees/E9zShidy8EI");
	  
	  System.out.println("Status Code:"+response.getStatusCode());
	  
	  response.prettyPrint();
	  
	  Assert.assertEquals(response.getStatusCode(),200);
  }
}
