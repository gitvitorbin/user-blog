package br.userblog.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.userblog.utils.CommonMethods;


public class UserBlogFlowTest {
	
	@Test
	public void validateEmail() {				
						
		//1. Search for the user with user name “Delphine”.		
		String name = "Delphine";
		String userId = CommonMethods.getUserId(name);
		
	    //2. Use the details fetched to make a search for the posts written by the user.		
		List<Integer> postsFromUser = CommonMethods.getPostsFromUser(userId);		
		
	    //3. For each post, fetch the comments and validate if the e-mails in the comment section are in the proper format.
		Assert.assertTrue(CommonMethods.validateEmailsFromCommentators(postsFromUser));		
		
	}

}
