package sendingbodyasObject;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SendingJsonAsObject {

	@Test
	public void createWorkSpace()
	{
		
		HashMap<String, String> innerMap = new HashMap<String, String>();
		
		innerMap.put("name", "JsonObject");
		innerMap.put("type", "team");
		innerMap.put("description", "Creating workspace using body as Object");

		HashMap<String, HashMap<String, String>> outerMap = new HashMap<String, HashMap<String,String>>();
		
		outerMap.put("workspace", innerMap);		
		
		RestAssured.baseURI = "https://api.getpostman.com";
		
		Response response   = given()
							
							.header("x-api-key","PMAK-653a5ac515bcfa00385e147c-77b7a1f7f0e0150857c45401ac8dfcaca6")
							
							.body(outerMap)
							
							.log().all()
							
							.when()
							
							.post("/workspaces")
							
							.then()
							
							.log().all()
							
							.extract()
							
							.response();
	}
	
}
