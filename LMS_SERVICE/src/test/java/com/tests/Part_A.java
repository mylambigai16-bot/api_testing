package com.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import com.utilities.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Part_A {

	ConfigReader con;
	String token;
	String url;

	public Part_A() throws IOException {

		con = new ConfigReader("Config.properties");
		token = con.getData("token");
		url = con.getData("BaseUrl");
	}

	@Test
	public void HealthCheck() throws IOException {

		Response res = RestAssured.given().header("Authorization", "Bearer " + token).when().get(url);

		res.then().statusCode(200);
		res.prettyPrint();
	}

	@Test
	public void InvalidLogin() throws IOException {

		Map<String, Object> payload = new HashMap<>();

		payload.put("email", "mai@gmail.com");
		payload.put("password", "123");

		Response res = RestAssured.given().contentType(ContentType.JSON).body(payload).when().post(url + "/user/login");
		res.then().statusCode(400);
		res.prettyPrint();

	}

	@Test
	public void GetAllInstitution() {

		Response res = RestAssured.given().header("Authorization", "Bearer " + token).when()
				.get(url + "/getAll/institution");
		res.then().statusCode(200);
		res.prettyPrint();
	}

	@Test
	public void GetAllRoles() {

		Response res = RestAssured.given().header("Authorization", "Bearer " + token).when().get(url + "/roles/getAll");
		res.then().statusCode(200);
		res.prettyPrint();
	}

	@Test
	public void GetAllCourse() {

		Response res = RestAssured.given().header("Authorization", "Bearer " + token).when()
				.get(url + "/courses-structure/getAll");
		res.then().statusCode(200);
		res.prettyPrint();
	}
}
