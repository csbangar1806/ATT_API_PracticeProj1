package specbuilders;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqResSpecBuilder {


	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void initRequestAndResponseSpec()
	{
		// Common properties for request

		RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();

		reqSpecBuilder.setBaseUri("https://petstore.swagger.io/v2");

		reqSpecBuilder.log(LogDetail.ALL);

		requestSpecification = reqSpecBuilder.build();

		
		// Common properties for response

		ResponseSpecBuilder resSpecBuilder = new ResponseSpecBuilder();

		resSpecBuilder.expectStatusCode(200);

		resSpecBuilder.expectContentType(ContentType.JSON);

		resSpecBuilder.log(LogDetail.ALL);

		responseSpecification = resSpecBuilder.build();
	}

	String messagevalue;

	@Test(priority = 1)
	public void createAnUser()
	{

		Response response = given()
				
				.spec(requestSpecification)

				.body("{\r\n"
						+ "  \"id\": 0,\r\n"
						+ "  \"username\": \"rest2020User12\",\r\n"
						+ "  \"firstName\": \"RestAssured1\",\r\n"
						+ "  \"lastName\": \"User\",\r\n"
						+ "  \"email\": \"restassured.user@att.com\",\r\n"
						+ "  \"password\": \"Test@1234\",\r\n"
						+ "  \"phone\": \"9876543212\",\r\n"
						+ "  \"userStatus\": 0\r\n"
						+ "}")
				.header("Content-Type", "application/json")

				.when()

				.post("/user")

				.then()
				
				.spec(responseSpecification)

				.extract()

				.response();

		JsonPath jp = response.jsonPath();

		messagevalue = jp.getString("message");

		System.out.println("Message value is "+messagevalue);
	}

	@Test(priority = 2)
	public void getUserDetails()
	{

		Response response = given()
				
				.spec(requestSpecification)

				.pathParam("createdusername", "rest2020User12")

				.when()

				.get("/user/{createdusername}")

				.then()
				
				.spec(responseSpecification)

				.extract()

				.response();

		JsonPath jp = response.jsonPath();

		String idvalue= jp.getString("id");

		System.out.println("ID value is : "+idvalue);

		Assert.assertEquals(idvalue, messagevalue);

	}
}
