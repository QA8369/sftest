package com.sftest.rest;

import org.testng.annotations.Test;

import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class SFLogin1Test {
	
	
	@Test(enabled=false)
	public void test_getToken() {
		
		String login_url="https://login.salesforce.com/services/oauth2/token";
		String account_url="https://na35.salesforce.com/services/data/v41.0/sobjects";
		String grant_type="password";
		String client_id="3MVG9szVa2RxsqBasl6lquPf_tt_9QqBiVn3UO_rYe6tXPMG5ORRlqWQUjolPoLQPndEmoq87Rz2VhAYIvmtI";
		String client_secret="6505635864408707693";
		String username="ytest@gmail.com";
		String password="xxxxx";
		//String access_token1="00D41000002G1ey!ARAAQD_zKDb8RS_SgZdUerWl.S5cjLAjouaMcna46MNX2oDHnujrw..Th_EVVKi.68U9iYxX_vrkTU4rDW7cSiONkVMx6U4V";
		
		//for relaxing non secure https certificates
		
		useRelaxedHTTPSValidation();
		
		config = new RestAssuredConfig().encoderConfig(encoderConfig().defaultContentCharset("UTF-8"));
		baseURI=login_url;
		
		
		String access_token=given()
			.queryParam("grant_type", grant_type)
			.queryParam("client_id", client_id)
			.queryParam("client_secret", client_secret)
			.queryParam("username", username)
			.queryParam("password", password)
		.when()
		.post()
		.then().log().body()
		.body("token_type",equalTo("Bearer"))
		.extract()
		.path("access_token");
		
		String auth_token="Bearer "+access_token;
		
		
	
	String createbody="{\n" + 
			"   \n" + 
			"    \"Name\": \"Test134\",\n" + 
			"    \n" + 
			"    \n" + 
			"    \"AccountNumber\": \"134\"\n" + 
			"   \n" + 
			"   \n" + 
			"}";
	      
		String account_id=given()
		.baseUri(account_url)
		.and().contentType(ContentType.JSON).accept(ContentType.JSON).header("Authorization", auth_token)
		.body(createbody)
		.when()
		.post("/Account")
		.then().log().body().statusCode(201).extract()
		.path("id");
		
		given()
	      .baseUri(account_url)
	      .and().contentType(ContentType.JSON).accept(ContentType.JSON).header("Authorization", auth_token)
	      .when()
	      .get("/Account/" +account_id)
	      .then().log().body();
		
		String updatebody="{\n" + 
				"   \n" + 
				"    \"Name\": \"Test13\",\n" + 
				"    \n" + 
				"    \n" + 
				"    \"AccountNumber\": \"31\"\n" + 
				"   \n" + 
				"   \n" + 
				"}";
		
		given()
		.baseUri(account_url)
		.and().contentType(ContentType.JSON).accept(ContentType.JSON).header("Authorization", auth_token)
		.body(updatebody)
		.when()
		.patch("/Account/" +account_id)
		.then().statusCode(204);
		
		given()
	      .baseUri(account_url)
	      .and().contentType(ContentType.JSON).accept(ContentType.JSON).header("Authorization", auth_token)
	      .when()
	      .get("/Account/" +account_id)
	      .then().log().body();
		
	
		
	}
	
	

}
