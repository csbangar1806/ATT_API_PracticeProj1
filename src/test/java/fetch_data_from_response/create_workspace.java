package fetch_data_from_response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class create_workspace {

	
	@Test
	public void createWorkspace()
	{
		
		RestAssured.baseURI = "https://api.getpostman.com";
		
		Response response   = given()
							
							.header("x-api-key","PMAK-653a5ac515bcfa00385e147c-77b7a1f7f0e0150857c45401ac8dfcaca6")
							
							.body("{\r\n"
									+ "    \"workspace\": {\r\n"
									+ "        \"name\": \"Practice Postman 2023\",\r\n"
									+ "        \"type\": \"personal\",\r\n"
									+ "        \"description\": \"Practice session for Postman\"\r\n"
									+ "    }\r\n"
									+ "}")
							
							.when()
							
							.post("/workspaces")
							
							.then()
							
							.extract()
							
							.response();
		
		
		String res = response.asPrettyString();
		
		System.out.println(res);
		
		JsonPath js = response.jsonPath();
					
		String workspaceIdValue = js.getString("workspace.id");
		
		System.out.println("Created Workspace ID Value --> " + workspaceIdValue); 
		
		
							
							
							
	}
}
