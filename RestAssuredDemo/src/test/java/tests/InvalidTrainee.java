package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class InvalidTrainee {
  @Test
  public void invalidTrainee() {
	  
      Response response = RestAssured
    		  .given()
    		  .when()
    		  .get("http://localhost:3000/trainees/znvAXrDd2uc");
	  
	  System.out.println("Status Code:"+response.getStatusCode());
	  
	  response.prettyPrint();
	  
	  Assert.assertEquals(response.getStatusCode(),404);
  }
}
