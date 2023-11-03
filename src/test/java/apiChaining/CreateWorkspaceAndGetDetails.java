package apiChaining;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.hasEntry;

import static io.restassured.RestAssured.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;


public class CreateWorkspaceAndGetDetails {

	String postIDValue;
	
	@Test (priority = 1)
	public void createWorkspace()
	{
		RestAssured.baseURI = "https://api.getpostman.com" ;
					
		Response response = given()
							
							.header("x-api-key","PMAK-653a5ac515bcfa00385e147c-77b7a1f7f0e0150857c45401ac8dfcaca6")

							.body("{\r\n"
									+ "    \"workspace\": {\r\n"
									+ "        \"name\": \"ATT Postman 2023\",\r\n"
									+ "        \"type\": \"personal\",\r\n"
									+ "        \"description\": \"ATT Batch Postman 2023\"\r\n"
									+ "    }\r\n"
									+ "}")
							
							.header("Content-Type", "application/json")
							
							.log().all()
							
							.when()
							
							.post("/workspaces")
							
							.then()
							
							.log().all()
							
							.extract()
							
							.response();
		
		JsonPath js = response.jsonPath();
		
		postIDValue = js.getString("workspace.id");
		
		System.out.println("Workspace ID Value : " + postIDValue);
		
		System.out.println("-----------------------------------------------------------");
	}
	
	@Test (priority = 2)
	public void getDetails()
	{
		RestAssured.baseURI = "https://api.getpostman.com" ;
		
		Response response = given()
							
							.pathParam("workspaceID", postIDValue)
							
							.header("x-api-key","PMAK-653a5ac515bcfa00385e147c-77b7a1f7f0e0150857c45401ac8dfcaca6")
							
							.log().all()
							
							.when()
							
							.get("/workspaces/{workspaceID}")
							
							.then()
							
							.assertThat()
							
							.body("workspace", hasEntry("id", postIDValue))
							
							.log().all()
							
							.extract()
							
							.response();
		
		JsonPath js = response.jsonPath();
		
		String getIDValue = js.getString("workspace.id");
		
		System.out.println("Workspace ID Value : " + getIDValue);
		
		System.out.println("-----------------------------------------------------------");


		Assert.assertEquals(getIDValue, postIDValue);		
							

	}
}
