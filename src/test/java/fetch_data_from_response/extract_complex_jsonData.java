package fetch_data_from_response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class extract_complex_jsonData {


	@Test
	public void getUserDetails()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		Response response = given()
		
							.when()
		
							.get("/api/users?page=2")
		
							.then()
		
							.extract()
		
							.response();
		
		String strResponse = response.asPrettyString();
		
		System.out.println(strResponse);
		
		int statusCode = response.statusCode();
		System.out.println("My status Code --> " + statusCode);
		
		JsonPath js = response.jsonPath();
		
		int pageValue = js.getInt("page");
		System.out.println("Page value --> " + pageValue);
		
		String fname = js.getString("data[0].first_name");
		System.out.println("First Name --> " + fname);
		
		String firstIndexEmail = js.getString("data[1].email");
		System.out.println("First Index Email --> " + firstIndexEmail);
			
	}
}
