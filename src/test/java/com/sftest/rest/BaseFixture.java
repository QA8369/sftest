package com.sftest.rest;

import org.testng.annotations.Test;

import com.sftest.rest.utils.SFUtil;

import io.restassured.config.RestAssuredConfig;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.AfterSuite;

public class BaseFixture {
	
	
	protected SFUtil sfutil;
	protected String access_token;
	protected String auth_token;

  @BeforeTest
  public void beforeTest() {
	  
	 
	  
	 
	 
	  
	  
	  
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  sfutil=new SFUtil();
	  
	  useRelaxedHTTPSValidation();
		
		config = new RestAssuredConfig().encoderConfig(encoderConfig().defaultContentCharset("UTF-8"));
		baseURI=sfutil.getProperty("login_url");
		
	  
		 System.out.println( sfutil.getProperty("login_url"));
	  
	  access_token=given()
				.queryParam("grant_type", sfutil.getProperty("grant_type"))
				.queryParam("client_id", sfutil.getProperty("client_id"))
				.queryParam("client_secret", sfutil.getProperty("client_secret"))
				.queryParam("username", sfutil.getProperty("username"))
				.queryParam("password", sfutil.getProperty("password"))
			.when()
			.post()
			.then().log().body()
			.body("token_type",equalTo("Bearer"))
			.extract()
			.path("access_token");
			
			auth_token="Bearer "+access_token;
  }

  @AfterSuite
  public void afterSuite() {
  }
  
  

}
