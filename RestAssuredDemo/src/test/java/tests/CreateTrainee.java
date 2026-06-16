package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateTrainee {
	@Test
	public void createTrainee() {

		Map<String, Object> payload = new HashMap<>();
		payload.put("Name", "Mugan");
		payload.put("email", "mugan@gamil.com");
		payload.put("Company", "Nvidia");

		Response response = RestAssured.given().contentType(ContentType.JSON).body(payload).when()
				.post("http://localhost:3000/trainees");

		System.out.println("Status Code:" + response.getStatusCode());
		System.out.println("Status :" + response.getStatusLine());
		System.out.println("ID: " + response.getSessionId());
		response.prettyPrint();

		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
