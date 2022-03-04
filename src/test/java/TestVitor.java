
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.List;
import java.util.regex.Pattern;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class TestVitor {
	
	/*
	  Exercise:
	  1. Search for the user with username “Delphine”.
	  2. Use the details fetched to make a search for the posts written by the user.
	  3. For each post, fetch the comments and validate if the emails in the comment section are in the proper format.
	*/
	
	public static boolean patternMatches(String emailAddress, String regexPattern) {
	    return Pattern.compile(regexPattern)
	      .matcher(emailAddress)
	      .matches();
	}
	
	@Test
	public void outrasFormasDeTestar() {		
		
	    //1. Search for the user with username “Delphine”.
		String userName = "Delphine";
		Response responseUser = request(Method.GET, "https://jsonplaceholder.typicode.com/users?username=" + userName);
		JsonPath jsonPathEvaluatorUser = responseUser.jsonPath();			
		String id = jsonPathEvaluatorUser.get("id").toString();
		//System.out.println("o primeiro com colchetes " + id);
		id = id.replaceAll("[\\[\\](){}]","");	
		//System.out.println("o segundo sem os colchetes " + id);
		
		
	    //2. Use the details fetched to make a search for the posts written by the user.
		Response responseUserPosts = request(Method.GET, "https://jsonplaceholder.typicode.com/posts?userId=" + id);
		JsonPath jsonPathEvaluatorUserPosts = responseUserPosts.jsonPath();
		List<Integer> allPosts = jsonPathEvaluatorUserPosts.getList("id");
		//System.out.println(allPosts);
		
		
	    //3. For each post, fetch the comments and validate if the emails in the comment section are in the proper format.		
		for(Integer postId : allPosts) {
			//System.out.println(allPosts);
			System.out.println(postId);
			Response responseCommentsEmail = RestAssured.request(Method.GET, "https://jsonplaceholder.typicode.com/comments?postId="+postId);
			JsonPath jsonPathEvaluatorCommentsEmail = responseCommentsEmail.jsonPath();
			List<String> allComments = jsonPathEvaluatorCommentsEmail.getList("email");
				for(String comment : allComments) { 
					System.out.println(comment);
				    String emailAddress = comment;
				    String regexPattern = "^(.+)@(\\S+)$";
				    assertTrue(TestVitor.patternMatches(emailAddress, regexPattern));				    
				}
		}
	}
	
	@Test
	public void cenarioDois() {
		System.out.println("vitor binsfeld");
	}
	
}