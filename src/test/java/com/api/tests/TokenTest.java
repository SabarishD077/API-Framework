package com.api.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.restclient.RestClient;
import com.api.util.Token;

import io.restassured.response.Response;

public class TokenTest {
	
String AccessToken;

@BeforeMethod
public void setUp()
{
	AccessToken=Token.getAccessToken();
}

@Test
public void testResWithToken()
{
	Response response=RestClient.doPost("JSON", "http://coop.apps.symfonycasts.com", 
			"/api/897/chickens-feed", AccessToken, null, true, null);
	System.out.println(response.prettyPrint());
}
@Test
public void testEggCollect()
{
	Response response=RestClient.doPost("JSON", "http://coop.apps.symfonycasts.com", 
			"/api/897/eggs-collect", AccessToken, null, true, null);
	System.out.println(response.prettyPrint());
}
@Test
public void testEggCountToday()
{
	Response response=RestClient.doPost("JSON", "http://coop.apps.symfonycasts.com", 
			"/api/897/eggs-count", AccessToken, null, true, null);
	System.out.println(response.prettyPrint());
}

}
