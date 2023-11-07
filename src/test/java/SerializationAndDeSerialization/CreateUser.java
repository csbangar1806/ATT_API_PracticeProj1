package SerializationAndDeSerialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import PojoClass.CreateUserReqBody;
import PojoClass.CreateUserResBody;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateUser {
	
	@Test(priority = 1)
	public void createAnUser()
	{
		
		CreateUserReqBody curb = new CreateUserReqBody();
		curb.setId(0);
		curb.setUsername("ATTSerialization");
		curb.setFirstName("Serialization");
		curb.setLastName("DeSerialization");
		curb.setEmail("att123@gmail.com");
		curb.setPassword("user@123");
		curb.setPhone("8765457100S");
		curb.setUserStatus(0);
		
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		CreateUserResBody userRes    =	 given()

									    .body(curb)

									    .header("Content-Type", "application/json")

									    .log().all()

									    .when()

									    .post("/user")
								
									    .then()

									    .log().all()

									    .extract()

									    .response()

									    .as(CreateUserResBody.class);
		
		String codeValue = userRes.getCode();
		System.out.println("Code Value : " + codeValue);
		String typeValue = userRes.getType();
		System.out.println("Type Value : " + typeValue);
		String messageValue = userRes.getMessage();
		System.out.println("Msg Value : " + messageValue);
	}

	
}
