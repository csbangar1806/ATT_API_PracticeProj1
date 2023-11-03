package basicsapicalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class deleteworkspace {

	@Test
	public void deleteWorkspace()
	{
		
		RestAssured.baseURI = "https://api.getpostman.com" ; //715475ff-b9e6-4959-80f0-24f3fbec2cf9
		
							Response res = given()
							
							.header("x-api-key","PMAK-653a5ac515bcfa00385e147c-77b7a1f7f0e0150857c45401ac8dfcaca6")

							.when()
							
							.delete("/workspaces/715475ff-b9e6-4959-80f0-24f3fbec2cf9")
							
							.then()
							
							.extract()
							
							.response();
							
			String str = res.asPrettyString();
			
			System.out.println(str);
	}
}
