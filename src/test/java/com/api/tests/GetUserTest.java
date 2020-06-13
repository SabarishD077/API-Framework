package com.api.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.api.restclient.RestClient;

import io.restassured.response.Response;

public class GetUserTest {
	
	String baseURI= "https://gorest.co.in";
	String basepath= "/public-api/users";
	String token= "3s3xRgt7IrZM7jpORC2rqk-r-kLiDGCrgOji";

@Test
public void getAllUserApiTest()
{
	Response response=RestClient.doGet("JSON", baseURI, basepath, token, null, true);
	System.out.println(response.prettyPrint());
	System.out.println("Response code is :" +response.statusCode());
}
	
@Test
public void getUserApiWithParamTest()
{
	Map<String, String> params=new HashMap<String, String>();
	params.put("first_name", "Erika");
	params.put("last_name", "Kunde");
	Response response=RestClient.doGet("JSON", baseURI, basepath, token, params, true);
	System.out.println(response.prettyPrint());
	System.out.println("Response code is :" +response.statusCode());
}

}
