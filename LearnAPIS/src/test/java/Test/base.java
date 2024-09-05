package Test;

import static org.testng.Assert.assertEquals;

import org.springframework.util.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class base {
	@Test //TestNg Annotate
	public void  test_1() {	
		//GET request 
		Response response = get("https://reqres.in/api/users?page=2");
		//Store the response in print responce data 
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getTime());
		
		System.out.println(response.getBody().asString());
		
		System.out.println(response.getStatusLine());
		
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		
		//Assertion for Run and Verify the status code pass and fail changes
		assertEquals(statusCode, 200);
		
	}
	@Test
	public void test_2() {
		
		baseURI="https://reqres.in/api/";
		given().
			get("users?page=2").
		then().
			statusCode(200).
		body("data[1].id",equalTo(8));
		
	}

}
