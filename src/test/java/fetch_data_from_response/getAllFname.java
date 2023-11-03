package fetch_data_from_response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getAllFname {

	@Test
	public void getAllFirstName()
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
		
		// getting array size
		
		int numberOfElements = js.getInt("data.size()");  // how many no of elements in the array 
		System.out.println("Total no of elements present --> " + numberOfElements);
		
		// get all first name
		
		System.out.println("----- All First Name -----");
		for(int i=0 ; i<6 ; i++)
		{
			String firstName = js.getString("data[" + i + "].first_name");
			System.out.println(firstName);
		}
		
		System.out.println("---------------------------------------------");
		
		// get last name who's email is george.edwards@reqres.in
		
		for(int j=0 ; j<=5 ; j++)
		{
			String email = js.getString("data[" + j + "].email");
			
			if(email.equals("george.edwards@reqres.in"))
			{
				String lName = js.getString("data[" + j + "].last_name");
				
				System.out.println("Last Name --> " + lName);
			}
		}
		
	}
	
}
