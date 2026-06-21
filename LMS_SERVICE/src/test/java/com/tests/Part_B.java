package com.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.utilities.ConfigReader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Part_B {

	ConfigReader con;
	String token;
	String url;

	public Part_B() throws IOException {

		con = new ConfigReader("Config.properties");
		token = con.getData("token");
		url = con.getData("BaseUrl");
	}

	@Test
	public void CreateNode() {

		JSONObject payload = new JSONObject();

		payload.put("title", "API Test Note");
		payload.put("content", "Created by Tester");
		payload.put("color", "#ffeb3b");
		payload.put("isPinned", false);

		Response response = RestAssured
				.given()
				.header("Authorization", "Bearer " + token)
				.header("Content-Type", "application/json")
				.body(payload.toString())
				.when()
				.post(url + "/create/notes");

		String noteId = response.jsonPath().getString("data._id");

		System.out.println("Created Note Id : " + noteId);

		response.then().statusCode(201).log().all();

	}

	@Test
	public void GetAllNode() {

		Response res = RestAssured
				.given()
				.header("Authorization", "Bearer " + token)
				.when()
				.get(url + "/getAll/notes");

		res.then().statusCode(200);
		System.out.println(res.prettyPrint());
	}

	@Test
	public void GetNodeById() {

		Response res = RestAssured
				.given()
				.header("Authorization", "Bearer " + token)
				.when()
				.get(url + "/getById/notes/6a381976462c4b9513514e56");

		res.then().statusCode(200);

	}

	@Test
	public void UpdateNode() {

		Map<String, Object> payload = new HashMap<>();

		payload.put("title", "Updated title");
		payload.put("content", "Updated content");

		Response res = RestAssured
				.given()
				.header("Authorization", "Bearer " + token)
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.put(url + "/update/notes/6a33d7d7a4ebe31fa6c8b514");

		res.then().statusCode(200);
		System.out.println(res.getStatusCode());
		System.out.println(res.asPrettyString());

	}

	@Test
	public void TogglePin() {

		Response res = RestAssured
				.given()
				.header("Authorization", "Bearer " + token)
				.when()
				.put(url + "/toggle-pin/notes/6a33d7d7a4ebe31fa6c8b514");

		res.then().statusCode(200);

		System.out.println(res.asPrettyString());
	}

	@Test
	public void deleteNote() {

	    String noteId = "6a349ba7b83abf7386bf2644";

	    Response res = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .when()
	            .delete(url + "/delete/notes/ById/" + noteId);

	    res.then().statusCode(200);

	    System.out.println(res.asPrettyString());
	}
}
