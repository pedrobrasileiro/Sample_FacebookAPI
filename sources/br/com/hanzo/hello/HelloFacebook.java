package br.com.hanzo.hello;

import java.util.List;

import com.restfb.DefaultFacebookClient;
import com.restfb.Facebook;
import com.restfb.FacebookClient;

public class HelloFacebook {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String accessToken = "AAAAAAITEghMBAPKoDsf9kfHwBdvBIXoMXJTRI8s7IgKNCSlmCNrHFlFiLJImWkODqqXwa7GSWZBTUcgoc31TC7TuxnHrqR3eYxe5k5wZDZD";
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
		
		String query = "select uid, name, birthday_date from user where uid in (select uid2 from friend where uid1=me())";
		List<UserBirthday> users = facebookClient.executeQuery(query, UserBirthday.class);
		
		for(UserBirthday user : users) {
			System.out.println("(" + user.uid+ ")" + user.name + " : " + user.birthday_date);
		}
	}
	

}
class UserBirthday {
	
	@Facebook
	String uid;
	
	@Facebook
	String name;
	
	@Facebook
	String birthday_date;
}
