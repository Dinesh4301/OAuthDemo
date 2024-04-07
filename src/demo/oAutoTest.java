package demo;

import static io.restassured.RestAssured.*;

import POJO.GetResp;
import io.restassured.path.json.JsonPath;

public class oAutoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String authResponse=given().log().all()
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js=new JsonPath(authResponse);
		String token=js.getString("access_token");
		System.out.println(token);
		
		GetResp courseResp=given().log().all()
		.queryParam("access_token", token)
		.when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetResp.class);
		
		System.out.println(courseResp.getLinkedIn());
	}

}
