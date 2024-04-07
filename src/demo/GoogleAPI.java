package demo;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import POJO.Courses;
import POJO.GetResp;
import POJO.Location;
import POJO.addPlace;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GoogleAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://rahulshettyacademy.com";

		
		addPlace add=new addPlace();
		
		add.setAddress("29, side layout, cohen 09, Diensh Address");
		add.setLanguage("English-India");
		Location location=new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		add.setLocation(location);
		add.setAccuracy(100);
		add.setName("Dinesh Jangid");
		add.setPhoneNumber("8087047193");
		List<String> list=new ArrayList<String>();
		list.add("body");
		list.add("bodybuilder");
		
		add.setTypes(list);
		add.setWebsite("www.google.com");
		
		Response res= given().log().all().queryParam("key", "qaclick123")
		.body(add)
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response();
		
		System.out.println(res.toString());
		
		
		
	}

}
