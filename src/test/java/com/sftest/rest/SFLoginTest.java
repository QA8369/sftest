package com.sftest.rest;

import org.testng.annotations.Test;

import com.sftest.rest.models.login.LoginResponse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class SFLoginTest {
	
	

	@Test
	public void loginTest() {

		// https://login.salesforce.com/services/oauth2/token?
		// grant_type=password&
		// client_id=3MVG9szVa2RxsqBasl6lquPf_tt_9QqBiVn3UO_rYe6tXPMG5ORRlqWQUjolPoLQPndEmoq87Rz2VhAYIvmtI&
		// client_secret=6505635864408707693&
		// username=rajeshwar.kottala1@gmail.com&
		// password=Suhith@1234
		
		String base_uri = "https://login.salesforce.com/services/oauth2";
		String url = "/token";
		
	config = new RestAssuredConfig().encoderConfig(encoderConfig().defaultContentCharset("UTF-8"));
	baseURI = base_uri;
	useRelaxedHTTPSValidation();
	
//	given()
//	.log().all()
//	.accept(ContentType.JSON)
//	.contentType(ContentType.JSON)
//	.queryParam("grant_type", "password")
//	.queryParam("client_id", "3MVG9szVa2RxsqBasl6lquPf_tt_9QqBiVn3UO_rYe6tXPMG5ORRlqWQUjolPoLQPndEmoq87Rz2VhAYIvmtI")
//	.queryParam("client_secret", "6505635864408707693")
//	.queryParam("username", "rajeshwar.kottala1@gmail.com")
//	.queryParam("password", "Suhith@1234").when()
//	.post(url).then().log().body().statusCode(200);

	ResponseBody response = given()
	.log().all()
	.accept(ContentType.JSON)
	.contentType(ContentType.JSON)
	.queryParam("grant_type", "password")
	.queryParam("client_id", "3MVG9szVa2RxsqBasl6lquPf_tt_9QqBiVn3UO_rYe6tXPMG5ORRlqWQUjolPoLQPndEmoq87Rz2VhAYIvmtI")
	.queryParam("client_secret", "6505635864408707693")
	.queryParam("username", "test23@gmail.com")
	.queryParam("password", "kkk").when()
	.post(url);
	
	JsonPath jsonPathEvaluator = response.jsonPath();
	
	LoginResponse loginResponse = new LoginResponse();
	
	loginResponse.setAccess_token(jsonPathEvaluator.get("access_token"));
	loginResponse.setId(jsonPathEvaluator.get("id"));
	loginResponse.setInstance_url(jsonPathEvaluator.get("instance_url"));
	loginResponse.setSignature(jsonPathEvaluator.get("signature"));
	loginResponse.setToken_type(jsonPathEvaluator.get("token_type"));
	loginResponse.setIssued_at(jsonPathEvaluator.get("issued_at"));
	
	System.out.println(loginResponse.toString());
	
	
//	given()
//	.log().all()
//	.accept(ContentType.JSON)
//	.contentType(ContentType.JSON)
//	.when()
//	.post("https://login.salesforce.com/services/oauth2/token?grant_type=password&client_id=3MVG9szVa2RxsqBasl6lquPf_tt_9QqBiVn3UO_rYe6tXPMG5ORRlqWQUjolPoLQPndEmoq87Rz2VhAYIvmtI&client_secret=6505635864408707693&username=rajeshwar.kottala1@gmail.com&password=Suhith@1234").then().statusCode(200);

	}

}
