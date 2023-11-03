package UploadAndDownload;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;


public class Upload_File {

	@Test
	public void uploadFile()
	{
		File image = new File("C:\\Users\\C S Bangar\\OneDrive\\Desktop\\a1.jpg");
		
		RestAssured.baseURI = "https://the-internet.herokuapp.com" ;
		
							given()
							
							.multiPart("file", image)
							
							.log().all()
							
							.when()
							
							.post("/upload")
							
							.then()
							
							.log().all();
							
							
							
	}
}
