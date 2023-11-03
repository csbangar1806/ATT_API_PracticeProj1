package apiChaining;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateUserAndGetUser {
	
	String messagevalue;
	
	@Test(priority = 1)
	public void createAnUser()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response response = given()
		
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"rest2023User12\",\r\n"
				+ "  \"firstName\": \"RestAssured1\",\r\n"
				+ "  \"lastName\": \"User\",\r\n"
				+ "  \"email\": \"restassured.user@att.com\",\r\n"
				+ "  \"password\": \"Test@1234\",\r\n"
				+ "  \"phone\": \"9876543212\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}")
		.header("Content-Type", "application/json")
		
		.log().all()
		
		.when()
		
		.post("/user")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		JsonPath jp = response.jsonPath();
		
		 messagevalue = jp.getString("message");
		
		System.out.println("Message value is "+messagevalue);
	}

	
	
	@Test(priority = 2)
	public void getUserDetails()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response response = given()
		
		.pathParam("createdusername", "rest2023User12")
		
		.when()
		
		.get("/user/{createdusername}")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
	JsonPath jp = response.jsonPath();
	
	String idvalue= jp.getString("id");
	
	System.out.println("ID value is : "+idvalue);
		
	Assert.assertEquals(idvalue, messagevalue);
		
	}
}
