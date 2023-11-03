package path_query_Parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class query_parameter {

	@Test
	public void getUserDetails()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		Response response = given()
		
							.log().all()
				
							.queryParam("page", "2")
							
					//		.queryParam("line", "5")  // if we have multiple query parameters
				
							.when()
		
						//	.get("/api/users?page=2") // original endpoints 
							
							.get("/api/users")
		
							.then()
		
							.log().all()
							
							.extract()
		
							.response();
		
		
			
	}
}
