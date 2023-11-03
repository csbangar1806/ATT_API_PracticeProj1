package Ecomm_App;

import org.testng.annotations.Test;

import groovy.grape.GrapeIvy;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;


public class LoginAPI {

	static String tokenValue;
	static String userIdValue;
	
	@Test (priority = 1)
	public void loginAPICall()
	{
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("userEmail", "test.user123@gmail.com");
		hm.put("userPassword", "Shree1234@");

 		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com" ;
		
		Response response = given()
							
							.header("Content-Type","application/json")
							
							.body(hm)
							
							.log().all()
							
							.when()
							
							.post("/api/ecom/auth/login")
							
							.then()
							
							.log().all()
							
							.extract()
							
							.response();
							
			JsonPath res = response.jsonPath();
			
			tokenValue = res.getString("token");
			userIdValue = res.getString("userId");
			
			System.out.println("Token Value : " + tokenValue);
			System.out.println("User ID Value : " + userIdValue);						
 	}
	
	@Test (priority = 2)
	public void addProduct()
	{
		//String path = System.getProperty("user.dir")+"\\src\\test\\resources\\test img 3.jpeg";
		
		//File image = new File(path);
		
		File image = new File("C:\\Users\\C S Bangar\\eclipse-workspace\\ATT_API_PracticeProj\\src\\test\\resources\\test img 3.jpeg");
		
		RestAssured.baseURI = "https://rahulshettyacademy.com" ;
		
							given()
							
							.header("Authorization", tokenValue)
							
							.param("productName", "casual shirt")
							
							.param("productAddedBy", userIdValue)
							
							.param("productCategory", "fashion")
							
							.param("productSubCategory", "shirt")
							
							.param("productPrice", "1500")
							
							.param("productDescription", "Party wear shirt")
							
							.param("productFor", "Women")
							
							.multiPart("productImage", image )
							
							.log().all()
							
							.when()
							
							.post("/api/ecom/product/add-product")
							
							.then()
							
							.log().all();						 
	}
}
