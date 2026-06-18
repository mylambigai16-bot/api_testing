package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreateTrainee {
	@Test
	public void createTrainee() {

		Map<String, Object> payload = new HashMap<>();
		payload.put("Name", "Mugai");
		payload.put("email", "mugai@gamil.com");
		payload.put("Company", "Nvidia");

		ValidatableResponse response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.post("http://localhost:3000/trainees") 
				.then()
				.statusCode(201);

//		System.out.println("Status Code:" + response.getStatusCode());
//		System.out.println("Status :" + response.getStatusLine());
//		System.out.println("ID: " + response.getSessionId());
//		response.prettyPrint();
//
//		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
