package path_query_Parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class path_parameter {

	@Test
	public void getUserDetail()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		Response response = given()
				
							.pathParam("path_parameter", "2")
		
							.when()
		
						//	.get("/api/users/2")
							
							.get("/api/users/{path_parameter}")
		
							.then()
		
							.log().all()
							
							.extract()
		
							.response();
		
			
	}
}
