package UploadAndDownload;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class Download_File {

	@Test
	
	public void downloadFile() throws IOException
	{
		
		String path = "D:\\Study Materials\\Downloaded File\\downloadedByCode.png" ;
		
		// "D:\Study Materials\Downloaded File"
		
		RestAssured.baseURI = "https://github.com" ;
		
		byte[] response   =   given()
							 
							 .log().all()
							 
							 .when()
							 
							 .get("/csbangar1806/ATT_Rest_Basics_BatchData/raw/master/src/test/resources/Test Product image2.png")
		
							 .then() 
							 
							 .log().all()
							 
							 .extract()
							 
							 .response()
							 
							 .asByteArray();
		
		FileOutputStream fos = new FileOutputStream(new File(path));
		
		fos.write(response);
		
		fos.close();
							 
							 
	}
}
