package fetch_data_from_response;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Fetct_Data_From_Readymade_Json {

	@Test
	public void fetchDataFromJson()
	{
		// JsonPath Class
		
		String jsonbody = "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
		
		// in previous Example we use jsonpath method to fetch data like --> JsonPath js = response.jsonPath();
		
		// but here we use jsonpath class, create its object and use it
		
	//	JsonPath jasonpath = new JsonPath(jsonbody);  // object creation
		
		JsonPath js = new JsonPath(jsonbody);

		String website = js.getString("dashboard.website");
		System.out.println("Website --> " + website);
		
		System.out.println("---------------------------------------");
		
//		Assignment:
		
//		1. Print No of courses returned by API
//		2. Print Purchase Amount
//		3. Print Title of the first course
//		4. Print All course titles and their respective Prices
//		5. Print no of copies sold by RPA Course
//		6. Verify if Sum of all Course prices matches with Purchase Amount
		
		// 1 --> 
		
		int numberOfCourse = js.getInt("courses.size()");
		System.out.println("No of courses --> " + numberOfCourse);
		
		System.out.println("---------------------------------------");

		// 2 -->
		
		 int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		 System.out.println("Purchase Amount --> " + purchaseAmount);
		 
		 System.out.println("---------------------------------------");

		 // 3 -->
		 
		 String titleOfFirstCourse = js.getString("courses[1].title");
		 System.out.println("Title of the first course --> " + titleOfFirstCourse);
		 System.out.println("---------------------------------------");

		 // 4 -->
		 
		 int courseSize = js.getInt("courses.size()");
		 
	//	 System.out.println(courseSize);
		 
		 for(int i=0 ; i<courseSize ; i++)
		 {
			 String titleName = js.getString("courses[" + i + "].title");
			 String price = js.getString("courses[" + i + "].price");
			 
			 System.out.println("Course Title: " + titleName);
			 System.out.println("Price: $" + price);
			 
			 System.out.println();
		 }
		 
		 System.out.println("---------------------------------------");

		 // 5 -->
		
		 String copiesByRPA = js.getString("courses[2].copies");
		 System.out.println("copies sold by RPA Course --> " + copiesByRPA);
		 
		 System.out.println("---------------------------------------");
		
		 // 6 -->
		 
		 int totalCost = 0;
		 
		 for(int i=0 ; i<courseSize ; i++)
		 {
			 int price = js.getInt("courses[" + i + "].price");
			 int copies = js.getInt("courses[" + i + "].copies");
			 
			 int courseCost = price * copies;
			 
			 totalCost = totalCost + courseCost;
		 }
		 
		 System.out.println("Total Cost --> " + totalCost);
		 
		 if(purchaseAmount == totalCost)
		 {
			 System.out.println("Sum of all Course prices matches with Purchase Amount");
		 }
		 else
		 {
			 System.out.println("No match");
		 }
		 
		 System.out.println("---------------------------------------");
	}
}
