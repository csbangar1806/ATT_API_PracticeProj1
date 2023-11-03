package assertionfromRestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;

import org.hamcrest.text.IsEqualIgnoringCase;


public class assertionProg1 {

	
	@Test
	public void getAllWorkspace()
	{
		
		RestAssured.baseURI = "https://api.getpostman.com";
							
	//	Response response = given()
		
							given()
							
							.header("x-api-key","PMAK-653a5ac515bcfa00385e147c-77b7a1f7f0e0150857c45401ac8dfcaca6")
							
							.when()
							
							.get("/workspaces")
							
							.then()
							
							.assertThat()
							
							.statusCode(200)  // assertion on status code
							
							.contentType(ContentType.JSON)  // assertion on content Type
							
							.header("Connection", "keep-alive") // assertion on header
													
							.log().all()
							
					//		.extract()
							
					//		.response();
		
			// Assertio on response Body 
							
			.body("workspaces[1]", hasKey("id")) // verify array has elemrnt id
							
			.body("workspaces.name", contains("My Workspace","CS_API_Work","ATT My workspace","MyObj Workspacee","ATT Evening Batch Postman workspace","ATT 24 June 2023 Evening Batch Postman Tool workspace","RestAssured Workspace to get Data","ATT  Batch Postman workspace2","API Chaining","Practice Postman 2023"))
			
				// name has all possible values in a specific sequence using contains method
							
			.body("workspaces.name", containsInAnyOrder("My Workspace","ATT My workspace","CS_API_Work","MyObj Workspacee","ATT Evening Batch Postman workspace","ATT 24 June 2023 Evening Batch Postman Tool workspace","RestAssured Workspace to get Data","ATT  Batch Postman workspace2","API Chaining","Practice Postman 2023"))

				// doesn't matter with specific sequence using containsAnyOrder method

			.body("workspaces.name", hasItem("CS_API_Work"))
				
				// whether name has one of the value -->  CS_API_Work
							
			.body("workspaces[1]", hasEntry("type", "personal"))
							
				// workspace 1 has an entry (key - value pair)
							
			.body("workspaces[1].name", equalToIgnoringCase("CS_API_WORK"));
							
				// whether the data is matching with the response by ignoring the cae
			
							
			
	}
}
