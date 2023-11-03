package basicsapicalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class updateworkspace {

	@Test
	public void updateWorkspace()
	{
		RestAssured.baseURI = "https://api.getpostman.com" ;
		
							Response res = given()
							
							.header("x-api-key","PMAK-653a5ac515bcfa00385e147c-77b7a1f7f0e0150857c45401ac8dfcaca6")

							.body("{\r\n"
									+ "    \"workspace\": {\r\n"
									+ "        \"name\": \"Postman ATT 27-10-2023\",\r\n"
									+ "        \"type\": \"personal\",\r\n"
									+ "        \"description\": \"Update name\"\r\n"
									+ "    }\r\n"
									+ "}   ")
							
							.when()
							
							.put("/workspaces/afee688f-bb3e-4d23-8375-a8ff7b0bd952")
							
							.then()
							
							.extract()
							
							.response();
							
			String result = res.asPrettyString();
			
			System.out.println(result);
	}
	
}
