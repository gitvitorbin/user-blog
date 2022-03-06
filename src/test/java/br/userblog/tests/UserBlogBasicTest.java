package br.userblog.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


/*
 *   Exercise: 
 *   1. Search for the user with user name “Delphine”.
 *   2. Use the details fetched to make a search for the posts written by the user.
 *   3. For each post, fetch the comments and validate if the e-mails in the comment section are in the proper format.
 */


public class UserBlogBasicTest {		
	
	public static RequestSpecification reqSpec;
	public static ResponseSpecification resSpec;
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.log(LogDetail.ALL);
		reqSpec = reqBuilder.build();
		
		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectStatusCode(200);
		resSpec = resBuilder.build();		
	}
	
	@Test
	public void validateUsersRoute() {
		given()
			.spec(reqSpec)
		.when()
			.get("/users")
		.then()
			.spec(resSpec)
			.body(is(not(nullValue())))
			.body(Matchers.containsString("Delphine"));
	}
	
	@Test
	public void validatePostsRoute() {
		given()
			.spec(reqSpec)
		.when()
			.get("/posts")
		.then()
			.spec(resSpec)
			.body(is(not(nullValue())));
	}
	
	@Test
	public void validateCommentsRoute() {
		given()
			.spec(reqSpec)
		.when()
			.get("/comments")
		.then()
			.spec(resSpec)
			.body(is(not(nullValue())));
	}		
}

