package basicsapicalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class createworkspace {

	
	@Test
	public void createWorkspace()
	{
		
		RestAssured.baseURI = "https://api.getpostman.com";
		
		Response response   = given()
							
							.header("x-api-key","PMAK-653a5ac515bcfa00385e147c-77b7a1f7f0e0150857c45401ac8dfcaca6")
							.body("{\r\n"
									+ "    \"workspace\": {\r\n"
									+ "        \"name\": \"PostMan ATT\",\r\n"
									+ "        \"type\": \"personal\",\r\n"
									+ "        \"description\": \"ATT Batch 2023\"\r\n"
									+ "    }\r\n"
									+ "}")
							
							.when()
							.post("/workspaces")
							
							.then()
							.extract()
							.response();
		
		String res		 = 	response.asPrettyString();
		
		System.out.println(res);
		
							
							
							
	}
}
