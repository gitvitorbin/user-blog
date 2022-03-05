package br.userblog.StepDefinition;
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
		String name = userName;
		Response responseUser = request(Method.GET, "https://jsonplaceholder.typicode.com/users?username=" + name);
		JsonPath jsonPathEvaluatorUser = responseUser.jsonPath();			
		String id = jsonPathEvaluatorUser.get("id").toString();
		id = id.replaceAll("[\\[\\](){}]","");
		return id;
	}
	
	public static List<Integer> getPostsFromUser(String id) {
		String idFromUser = id;
		Response responseUserPosts = request(Method.GET, "https://jsonplaceholder.typicode.com/posts?userId=" + idFromUser);
		JsonPath jsonPathEvaluatorUserPosts = responseUserPosts.jsonPath();
		List<Integer> allUserPosts = jsonPathEvaluatorUserPosts.getList("id");
		return allUserPosts;
	}
	
	public static void validateEmailFromUser(List<Integer> allUserPosts) {
		for(Integer postId : allUserPosts) {
			System.out.println(postId);
			Response responseCommentsEmail = RestAssured.request(Method.GET, "https://jsonplaceholder.typicode.com/comments?postId="+postId);
			JsonPath jsonPathEvaluatorCommentsEmail = responseCommentsEmail.jsonPath();
			List<String> allComments = jsonPathEvaluatorCommentsEmail.getList("email");
				for(String comment : allComments) { 
					System.out.println(comment);
					String emailAddress = comment;
					String regexPattern = "^(.+)@(\\S+)$";
					assertTrue("E-mail from the ", patternMatches(emailAddress, regexPattern));
				}
		}
	}

}
