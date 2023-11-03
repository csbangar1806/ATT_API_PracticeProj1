package basicsapicalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class FetchDataOfHeader1 {

	
	@Test
	public void fetch_Data_From_Header()
	{
		RestAssured.baseURI = "https://reqres.in" ;
		
		Response response 	= 	given()
				
								.log().all()
						
								.when()
						
								.get("/api/users?page=2")
						
								.then()
								
								.log().all()
						
								.extract()
							
								.response();
						
	}
}
