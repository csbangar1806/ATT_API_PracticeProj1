package sendingbodyasObject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class Mock_GetReq {

	
	@Test
	public void getResponse()
	{
		RestAssured.baseURI = "https://eb367897-e86d-4eb7-bce8-9c2a93d1c8dd.mock.pstmn.io" ;
		
							   given()
							   
							   .header("x-mock-response-code","200")
							   
							   .log().all()
							   
							   .when()
							   
							   .get("/attgetcall")
	
							   .then()
							   
							   .log().all();
	}
}
