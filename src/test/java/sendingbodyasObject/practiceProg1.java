package sendingbodyasObject;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class practiceProg1 {

	
	@Test
	public void postComplexEx()
	{
		
		List<Integer> arrayOfID = new ArrayList<Integer>();
		arrayOfID.add(5);
		arrayOfID.add(9);
		
		HashMap<String, Object> hm2 = new HashMap<String, Object>();
		hm2.put("id", 1001);
		hm2.put("type", "Regular");
		
		HashMap<String, Object> hm1 = new HashMap<String, Object>();
		hm1.put("id", arrayOfID);
		hm1.put("type", "Chocolate");
		
		// batter array list
		
		List<Object> batterArrayList = new ArrayList<Object>();
		batterArrayList.add(hm2);
		batterArrayList.add(hm1);
		
		// batter hash map
		
		HashMap<String, Object> battersHashMap = new HashMap<String, Object>();
		battersHashMap.put("batter", batterArrayList);
		
		
		// topping hashmap
		
		HashMap<String, Object> top1 = new HashMap<String, Object>();
		top1.put("id", 5001);
		top1.put("type", "None");
		
		HashMap<String, Object> top2 = new HashMap<String, Object>();
		top2.put("id", 5002);
		top2.put("type", "Glazed");
		
		HashMap<String, Object> top3 = new HashMap<String, Object>();
		top3.put("id", 5005);
		top3.put("type", "Sugar");
		
		// topping list
		
		List<Object> topList = new ArrayList<Object>();
		topList.add(top1);
		topList.add(top2);
		topList.add(top3);
		
		// Main obj hashmap
		
		HashMap<String, Object> mainJsonObjBodyHashMap = new HashMap<String, Object>();
		mainJsonObjBodyHashMap.put("ppu", 0.55);
		mainJsonObjBodyHashMap.put("batters", batterArrayList);
		mainJsonObjBodyHashMap.put("name", "Cake");
		mainJsonObjBodyHashMap.put("id", "0001");
		mainJsonObjBodyHashMap.put("type", "donut");
		mainJsonObjBodyHashMap.put("topping", topList);
		
		
		RestAssured.baseURI = 	"https://eb367897-e86d-4eb7-bce8-9c2a93d1c8dd.mock.pstmn.io" ;

		given()

		.header("x-mock-match-request-body","true")

		.header("Content-Type","application/json")

		.body(mainJsonObjBodyHashMap)

		.log().all()

		.when()

		.post("/complexcallpost")
		
		.then()

		.log().all();
		
	}
}
