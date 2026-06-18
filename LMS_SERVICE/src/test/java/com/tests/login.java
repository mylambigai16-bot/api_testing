package com.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utilities.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class login {
	@Test
	public void loginTest() throws IOException {

		Map<String, Object> payload = new HashMap<>();

		ConfigReader con = new ConfigReader("Config.properties");

		String url = con.getData("BaseUrl");
		payload.put("email", con.getData("email"));
		payload.put("password", con.getData("password"));

		Response res = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.post(url + "/user/login");

		res.then().statusCode(201);
		
		System.out.println(res.asPrettyString());
		String accessToken = res.jsonPath().getString("token");
		System.out.println(accessToken);

		Assert.assertEquals(res.getStatusCode(), 201);

		;
	}
}
