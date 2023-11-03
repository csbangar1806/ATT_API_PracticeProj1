package sendingbodyasObject;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ComplexPostCall {

	@Test
	public void postCall()
	{
		// creating body of the request
		
		HashMap<String, String> innerMap1 = new HashMap<String, String>();
		innerMap1.put("id", "100");
		innerMap1.put("type", "grains");
		
		HashMap<String, String> innerMap2 = new HashMap<String, String>();
		innerMap2.put("id", "101");
		innerMap2.put("type", "grocery");
		
		List<HashMap<String, String>> jsonObj = new ArrayList<HashMap<String,String>>();
		jsonObj.add(innerMap1);
		jsonObj.add(innerMap2);
		
		
		
		RestAssured.baseURI = 	"https://eb367897-e86d-4eb7-bce8-9c2a93d1c8dd.mock.pstmn.io" ;
		
								given()
							   
								.header("x-mock-match-request-body","true")
							   
								.header("Content-Type","application/json")
							  
								.body(jsonObj)
								
								.log().all()
							   
								.when()
							   
								.post("/postcall")
	
								.then()
							   
								.log().all();
	}
}
