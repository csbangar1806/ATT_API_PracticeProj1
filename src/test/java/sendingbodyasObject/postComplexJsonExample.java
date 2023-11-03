package sendingbodyasObject;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class postComplexJsonExample {

	@Test
	public void postCallEx1()
	{
		// creating body of the request

		// Defining inner most array which is the value of id
		
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(5);
		idList.add(9);
		
		// batter hash map creation
		
		HashMap<String, Object> batterHashMap1 = new HashMap<String, Object>();
		batterHashMap1.put("id", "1001");
		batterHashMap1.put("type", "Regular");
		
		HashMap<String, Object> batterHashMap2 = new HashMap<String, Object>();
		batterHashMap2.put("id", idList);
		batterHashMap2.put("type", "Chocolate");  
		 
		// Defining batters array
		
		List<HashMap<String, Object>> batterArrayList = new ArrayList<HashMap<String,Object>>();
		batterArrayList.add(batterHashMap1);
		batterArrayList.add(batterHashMap2);
		
		// Defining batters hashmap
		
		HashMap<String, List<HashMap<String, Object>>> battersHashMap = new HashMap<String, List<HashMap<String, Object>>>();
		battersHashMap.put("batter", batterArrayList);
			
		// Defining toppings map
		
		HashMap<String, String> topping1 = new HashMap<String, String>();
		topping1.put("id", "5001");
		topping1.put("type", "None");
		
		HashMap<String, String> topping2 = new HashMap<String, String>();
		topping2.put("id", "5002");
		topping2.put("type", "Glazed");
		
		HashMap<String, String> topping3 = new HashMap<String, String>();
		topping3.put("id", "5005");
		topping3.put("type", "Sugar");
		
		// Defining topping list
		
		List<HashMap<String, String>> toppingList = new ArrayList<HashMap<String,String>>();
		toppingList.add(topping1);
		toppingList.add(topping2);
		toppingList.add(topping3);
		
		// Main Json HashMap
		
		HashMap<String, Object> mainJsonObject = new HashMap<String, Object>();
		
		mainJsonObject.put("ppu", 0.55);
		mainJsonObject.put("batters", battersHashMap);
		mainJsonObject.put("name", "Cake");
		mainJsonObject.put("id", "0001");
		mainJsonObject.put("type", "donut");
		mainJsonObject.put("topping", toppingList);
		
		
		
		RestAssured.baseURI = 	"https://eb367897-e86d-4eb7-bce8-9c2a93d1c8dd.mock.pstmn.io" ;

								given()

								.header("x-mock-match-request-body","true")

								.header("Content-Type","application/json")

								.body(mainJsonObject)

								.log().all()

								.when()
		
								.post("/complexcallpost")
								
								.then()
		
								.log().all();
	}

}
