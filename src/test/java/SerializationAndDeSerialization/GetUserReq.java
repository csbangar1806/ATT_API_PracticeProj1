package SerializationAndDeSerialization;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import PojoClass.Data;
import PojoClass.GetUserResBody;
import fetch_data_from_response.getAllFname;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserReq {

	
	@Test
	public void getUserDetails()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		GetUserResBody getUserResBody = given()
		
										.when()
		
										.get("/api/users?page=2")
		
										.then()
										
										.log().all()
		
										.extract()
		
										.response()
		
										.as(GetUserResBody.class);
		
		Integer totalValue = getUserResBody.getTotal();
		System.out.println("Total Value : " + totalValue);
		
		// get fname from data array's 0th list
		String dataFnameValue = getUserResBody.getData().get(0).getFirst_name();
		System.out.println(dataFnameValue);
		
		// get email from data array's 3rd list
		String dataEmailValue = getUserResBody.getData().get(3).getEmail();
		System.out.println(dataEmailValue);
		
		 // get text value from support
		String supportTextValue = getUserResBody.getSupport().getText();
		System.out.println(supportTextValue);
		
		// Fetch all first name from json
		
		List<Data> listArray = getUserResBody.getData();
		Data zerothIndex = listArray.get(0);
		String fname 	 = zerothIndex.getFirst_name();
		System.out.println(fname);

		// fetch all first name from the array
		
		System.out.println("All First Name : ");
		for(int i=0; i<listArray.size(); i++)
		{
			String allFname = getUserResBody.getData().get(i).getFirst_name();
			 System.out.println(allFname);
		}
		
	}
}
