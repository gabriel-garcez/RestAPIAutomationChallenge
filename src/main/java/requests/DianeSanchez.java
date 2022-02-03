package requests;


import static io.restassured.RestAssured.given;

import java.nio.file.Path;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.URLs;
import resources.paths;



public class DianeSanchez {

	
	@Test
	public void get() {
		
		
		//Get URL
		RestAssured.baseURI=URLs.baseURLRickandMorty();
		
		//Pass Header
		RequestSpecification request = RestAssured.given();
		
		//Execute Request
		Response response = request.request(Method.GET, paths.DianeSanchezPath());
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		//Show Response
		String responseString = response.asString();
		System.out.println(responseString);
		
		//Take fields to validate
		int statusCode = response.getStatusCode();
		String name = jsonPathEvaluator.get("name");
		String status = jsonPathEvaluator.get("status");
				
		//Validate them 
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(name, "Diane Sanchez");
		Assert.assertEquals(status, "Dead");
	
			
	}
}
