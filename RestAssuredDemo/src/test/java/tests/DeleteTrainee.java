package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTrainee {
  @Test
  public void deleteTrainee() {
	 
      Response response = RestAssured
    		  .given()
    		  .when()
    		  .delete("http://localhost:3000/trainees/znvAXrDd2uc");
	  
	  System.out.println("Status Code:"+response.getStatusCode());
	  
	  response.prettyPrint();
	  
	  Assert.assertEquals(response.getStatusCode(),200);
	  
	  
  }
}
