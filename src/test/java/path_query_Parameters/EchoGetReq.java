package path_query_Parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;


public class EchoGetReq {

	@Test
	public void getEchoParam()
	{
		HashMap<String, String> qp = new HashMap<String, String>();
		
		qp.put("foo1", "bar1");
		qp.put("foo2", "bar2");
		
		RestAssured.baseURI = "https://postman-echo.com" ;
		
							given()
							
						//	.queryParams(qp)
							
							.queryParams("foo1", "bar1", "foo2", "bar2")
							
							.header("x-api-key","PMAK-653a5ac515bcfa00385e147c-77b7a1f7f0e0150857c45401ac8dfcaca6")

							.log().all()
							
							.when()
							
							.get("/get")
							
							.then()
							
							.log().all();
					
	}
}
