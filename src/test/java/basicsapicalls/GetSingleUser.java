package basicsapicalls;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class GetSingleUser {

	
	@Test
	public void getUserInfo()
	{
		
		RestAssured.baseURI = "https://reqres.in/";
			
			Response response = given()
								.when()
								.get("/api/users/2")
								.then()
								.extract()
								.response();
			
			String strRes = response.asPrettyString();
			
			System.out.println(strRes);
			
			int statusCode = response.getStatusCode();
			
			System.out.println("Status Code --> " + statusCode);
								
			Assert.assertEquals(statusCode, 200);
			
			long timevalue = response.getTime();
			
			System.out.println(timevalue);
								
	}
}
