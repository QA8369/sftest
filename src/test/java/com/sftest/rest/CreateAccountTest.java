package com.sftest.rest;

import org.testng.annotations.Test;

import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class CreateAccountTest extends BaseFixture{
	
	@Test
	public void test_creatAccountSuccess() {
		
		String createbody="{\n" + 
				"   \n" + 
				"    \"Name\": \"Test134\",\n" + 
				"    \n" + 
				"    \n" + 
				"    \"AccountNumber\": \"134\"\n" + 
				"   \n" + 
				"   \n" + 
				"}";
		
		given()
		.baseUri(sfutil.getProperty("account_url"))
		.and().accept(ContentType.JSON).contentType(ContentType.JSON)
		.header("Authorization" ,auth_token)
		.body(createbody)
		.when()
		.post("/Account")
		.then().log().body().statusCode(201);
		
	}
	
	@Test
	public void test_CreateAccountFail() {
		
		String createbody="{\n" + 
				"   \n" + 
				"    \"Name1\": \"Test134\",\n" + 
				"    \n" + 
				"    \n" + 
				"    \"AccountNumber\": \"134\"\n" + 
				"   \n" + 
				"   \n" + 
				"}";
		
		given()
		.baseUri(sfutil.getProperty("account_url"))
		.and().accept(ContentType.JSON).contentType(ContentType.JSON)
		.header("Authorization" ,auth_token)
		.body(createbody)
		.when()
		.post("/Account")
		.then().log().body().statusCode(400);
		
	}
	
	@Test
	public void test_CreateAccountSuccessfail1() {
		
		String createbody="{\n" + 
				"   \n" + 
				"    \"Name\": \"Test134\",\n" + 
				"    \n" + 
				"    \n" + 
				"    \"AccountNumber\": \"134\"\n" + 
				"   \n" + 
				"   \n" + 
				"}";
		
		given()
		.baseUri(sfutil.getProperty("account_url"))
		.and().accept(ContentType.JSON).contentType(ContentType.JSON)
		.header("Authorization" ,auth_token)
		.body(createbody)
		.when()
		.patch("/Account")
		.then().log().body().statusCode(405);
		
	}
	
	@Test
	public void test_creatAccount_unauthorized() {
		
		String createbody="{\n" + 
				"   \n" + 
				"    \"Name\": \"Test134\",\n" + 
				"    \n" + 
				"    \n" + 
				"    \"AccountNumber\": \"134\"\n" + 
				"   \n" + 
				"   \n" + 
				"}";
		
		given()
		.baseUri(sfutil.getProperty("account_url"))
		.and().accept(ContentType.JSON).contentType(ContentType.JSON)
		.header("Authorization" ,"auth1_token")
		.body(createbody)
		.when()
		.post("/Account")
		.then().log().body().statusCode(401);
		
	}
	

	@Test
	public void test_creatAccount_unauthorized_fail() {
		
		String createbody="{\n" + 
				"   \n" + 
				"    \"Name\": \"Test134\",\n" + 
				"    \n" + 
				"    \n" + 
				"    \"AccountNumber\": \"134\"\n" + 
				"   \n" + 
				"   \n" + 
				"}";
		
		given()
		.baseUri(sfutil.getProperty("account_url"))
		.and().accept(ContentType.JSON).contentType(ContentType.JSON)
		.header("Authorization" ,"auth1_token")
		.body(createbody)
		.when()
		.post("/Account")
		.then().log().body().statusCode(402);
		
	}
}
