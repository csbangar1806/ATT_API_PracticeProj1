package apiChaining;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class Prog1 {

	String msgValue;
	
	@Test (priority = 1)
	
	public void prog1()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2" ;
		
					Response response = given()
					.body("{\r\n"
							+ "  \"id\": 0,\r\n"
							+ "  \"username\": \"Practice1\",\r\n"
							+ "  \"firstName\": \"ATTPractice\",\r\n"
							+ "  \"lastName\": \"UserAB\",\r\n"
							+ "  \"email\": \"att.pra23@gmail.com\",\r\n"
							+ "  \"password\": \"Test@1235\",\r\n"
							+ "  \"phone\": \"8909764301\",\r\n"
							+ "  \"userStatus\": 0\r\n"
							+ "}")
					
					.header("Content-Type", "application/json")
					.when()
					.post("/user")
					.then()
					.log().all()
					.extract()
					.response();
					
					JsonPath js = response.jsonPath();
					msgValue = js.getString("message");
					System.out.println("Message Value : " +msgValue );
				
	}
	
	@Test (priority = 2)
	
	public void prog2()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2" ;
		
		Response response = given()
							
					.pathParam("uName","Practice1")
					
					.when()
					.get("/user/{uName}")
					.then()
					.log().all()
					.extract()
					.response();
					
					JsonPath js = response.jsonPath();
					String idValue = js.getString("id");
					System.out.println("ID Value : " +idValue );
					
					Assert.assertEquals(idValue, msgValue);
				
	}
	
}
