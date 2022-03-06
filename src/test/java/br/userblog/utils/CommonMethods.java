package br.userblog.utils;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.request;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.regex.Pattern;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class CommonMethods {
	
	public static boolean patternMatches(String emailAddress, String regexPattern) {
	    return Pattern.compile(regexPattern)
	      .matcher(emailAddress)
	      .matches();
	}
	
	public static String getUserId(String userName) {
		baseURI = "https://jsonplaceholder.typicode.com";
		String name = userName;
		Response responseUser = request(Method.GET, "/users?username=" + name);
		JsonPath jsonPathEvaluatorUser = responseUser.jsonPath();			
		String id = jsonPathEvaluatorUser.get("id").toString();
		id = id.replaceAll("[\\[\\](){}]","");
		return id;
	}
	
	public static List<Integer> getPostsFromUser(String id) {
		baseURI = "https://jsonplaceholder.typicode.com";
		String idFromUser = id;
		Response responseUserPosts = request(Method.GET, "/posts?userId=" + idFromUser);
		JsonPath jsonPathEvaluatorUserPosts = responseUserPosts.jsonPath();
		List<Integer> allUserPosts = jsonPathEvaluatorUserPosts.getList("id");
		return allUserPosts;
	}
	
	public static void validateEmailsFromComment(List<Integer> allUserPosts) {
		baseURI = "https://jsonplaceholder.typicode.com";
		for(Integer postId : allUserPosts) {
			Response responseCommentsEmail = RestAssured.request(Method.GET, "/comments?postId="+postId);
			JsonPath jsonPathEvaluatorCommentsEmail = responseCommentsEmail.jsonPath();
			List<String> allComments = jsonPathEvaluatorCommentsEmail.getList("email");
				for(String comment : allComments) { 
					String emailAddress = comment;
					String regexPattern = "^(.+)@(\\S+)$";
					assertTrue("E-mail is not valid", patternMatches(emailAddress, regexPattern));
				}
		}
	}

}
