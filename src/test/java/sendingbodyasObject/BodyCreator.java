package sendingbodyasObject;

public class BodyCreator {

	
	public static String getBody() {
		
		String body = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"restUser01\",\r\n"
				+ "  \"firstName\": \"RestAsr1\",\r\n"
				+ "  \"lastName\": \"UserRest\",\r\n"
				+ "  \"email\": \"restassured.user@att.com\",\r\n"
				+ "  \"password\": \"Test@1234\",\r\n"
				+ "  \"phone\": \"9876543500\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}" ;
		
		return body ;
	}
}
