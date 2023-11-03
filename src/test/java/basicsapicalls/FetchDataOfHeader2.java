package basicsapicalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class FetchDataOfHeader2 {

	
	@Test
	public void fetch_Data_From_Header()
	{
		RestAssured.baseURI = "https://reqres.in" ;
		
		Response response 	= 	given()
				
					//			.log().all()
						
								.when()
						
								.get("/api/users?page=2")
						
								.then()
								
						//		.log().all()
						
								.extract()
							
								.response();
		
		Headers header = response.headers();
		
		String headerValue = header.toString();  // return complete header value
		
		System.out.println(headerValue);
		
		// fetching specific value from response header
		
		 String ageValueFromHeader = response.getHeader("Age"); // getting age value
		 System.out.println("Age Value --> " + ageValueFromHeader);
		 
		 String cfValue = response.getHeader("CF-RAY");
		 System.out.println("CF Value --> " + cfValue);
		 
		 String dateValue = response.getHeader("Date");
		 System.out.println("Date --> " + dateValue);
		 
		 
						
	}
}
