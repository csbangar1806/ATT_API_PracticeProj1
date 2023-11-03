package sendingbodyasObject;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class SendingBodyUsingString {


	String messagevalue;
	
	@Test(priority = 1)
	public void createAnUser()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

	//	Response response = given()
		
				given()

				.body(BodyCreator.getBody())
				
				.header("Content-Type", "application/json")

				.log().all()

				.when()

				.post("/user")

				.then()

				.log().all();

//				.extract()
//
//				.response();
//
//		JsonPath jp = response.jsonPath();
//
//		messagevalue = jp.getString("message");
//
//		System.out.println("Message value is "+messagevalue);
	}
	
}
