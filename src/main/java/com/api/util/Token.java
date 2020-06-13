package com.api.util;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Token {
	

public static String getAccessToken()
{
	Map<String, String> formparameters=new HashMap<String, String>();
	formparameters.put("client_id", "simpleapitest");
	formparameters.put("client_secret", "bb3b3caa5dbeb5f8696b4932d75cb508");
	formparameters.put("grant_type", "client_credentials");
	
	Response tokenres=RestAssured.given().formParams(formparameters).when()
		.post("http://coop.apps.symfonycasts.com/token");
	
	return tokenres.jsonPath().getString("access_token");
}


}
