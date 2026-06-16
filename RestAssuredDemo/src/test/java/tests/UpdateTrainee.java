package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateTrainee {
  @Test
  public void updateTraineeTest() {
	  
	  Map<String, Object> payload = new HashMap<>();
	  payload.put("Name", "Maya");
	  payload.put("email", "may@gmail.com");
	  payload.put("Company", "spaceX");
	  
	  Response res = RestAssured
			  .given()
			  .contentType(ContentType.JSON)
			  .body(payload)
			  .when()
			  .put("http://localhost:3000/trainees/1");
	  
	  System.out.println("Status code: "+res.statusCode());
	  res.prettyPrint();
	  
	  Assert.assertEquals(res.statusCode(), 200);
  }
}
