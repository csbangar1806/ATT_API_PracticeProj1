package basicsapicalls;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_A_Specific_Workspace {

	@Test
	public void getAWorkspace()
	{
		
		RestAssured.baseURI = "https://api.getpostman.com";
							
		Response response = given()
							
							.header("x-api-key","PMAK-653a5ac515bcfa00385e147c-77b7a1f7f0e0150857c45401ac8dfcaca6")
							
							.when()
							
							.get("/workspaces/715475ff-b9e6-4959-80f0-24f3fbec2cf9")
							
							.then()
							
							.extract()
							
							.response();
							
		String strRes = response.asPrettyString();
		
		System.out.println(strRes);
		
		int statusCode = response.statusCode();
		
		System.out.println("Status Code -->  " + statusCode);
		
		Assert.assertEquals(statusCode, 200);
							
	}
	
}
