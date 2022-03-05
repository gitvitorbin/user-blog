package br.userblog.Tests;

import org.junit.Test;

import br.userblog.StepDefinition.CommonMethods;

import java.util.List;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;
import java.util.regex.Pattern;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


/*
 *   Exercise: 
 *   1. Search for the user with user name “Delphine”.
 *   2. Use the details fetched to make a search for the posts written by the user.
 *   3. For each post, fetch the comments and validate if the emails in the comment section are in the proper format.
 */


public class UserBlogApiTest {		
	
	@Test
	public void validateEmail() {				
		
		//1. Search for the user with username “Delphine”.		
		String userId = CommonMethods.getUserId("Delphine");
		
	    //2. Use the details fetched to make a search for the posts written by the user.		
		List<Integer> allPosts = CommonMethods.getPostsFromUser(userId);		
		
	    //3. For each post, fetch the comments and validate if the emails in the comment section are in the proper format.
		CommonMethods.validateEmailFromUser(allPosts);		
		
	}
	
	@Test
	public void validateStatusCode() {
		System.out.println("new auto test case for status code");
	}
	
}

/*
String userName = "Delphine";
Response responseUser = request(Method.GET, "https://jsonplaceholder.typicode.com/users?username=" + userName);
JsonPath jsonPathEvaluatorUser = responseUser.jsonPath();			
String id = jsonPathEvaluatorUser.get("id").toString();
id = id.replaceAll("[\\[\\](){}]","");	

Response responseUserPosts = request(Method.GET, "https://jsonplaceholder.typicode.com/posts?userId=" + id);
JsonPath jsonPathEvaluatorUserPosts = responseUserPosts.jsonPath();
List<Integer> allPosts = jsonPathEvaluatorUserPosts.getList("id");

for(Integer postId : allPosts) {
	System.out.println(postId);
	Response responseCommentsEmail = RestAssured.request(Method.GET, "https://jsonplaceholder.typicode.com/comments?postId="+postId);
	JsonPath jsonPathEvaluatorCommentsEmail = responseCommentsEmail.jsonPath();
	List<String> allComments = jsonPathEvaluatorCommentsEmail.getList("email");
		for(String comment : allComments) { 
			System.out.println(comment);
		    String emailAddress = comment;
		    String regexPattern = "^(.+)@(\\S+)$";
		    assertTrue("E-mail from the ", TestVitor.patternMatches(emailAddress, regexPattern));
		}
}
*/