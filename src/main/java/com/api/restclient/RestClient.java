package com.api.restclient;

import java.util.Map;

import com.api.util.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class RestClient {
	
public static Response doGet(String contenttype, String baseURI, String basepath, 
		String token, Map<String, String> params, boolean log)
{
	setBaseURI(baseURI);
	RequestSpecification request=createRequest(contenttype, token, params, log);
	return getResponse("GET", request,basepath);
		
}

public static Response doPost(String contenttype, String baseURI, String basepath, 
		String token, Map<String, String> params, boolean log, Object object)
{
	setBaseURI(baseURI);
	RequestSpecification request=createRequest(contenttype, token, params, log);
	String Jsonpayload= TestUtil.getSerializedJson(object);
	request.body(Jsonpayload);
	return getResponse("POST", request,basepath);
		
}

public static Response doPut(String contenttype, String baseURI, String basepath, 
		String token, Map<String, String> params, boolean log, Object object)
{
	setBaseURI(baseURI);
	RequestSpecification request=createRequest(contenttype, token, params, log);
	String Jsonpayload= TestUtil.getSerializedJson(object);
	request.body(Jsonpayload);
	return getResponse("PUT", request,basepath);
		
}
private static void setBaseURI(String baseURI)
{
	try {
		baseURI=RestAssured.baseURI;	
	}
	catch(Exception e)
	{
		System.out.println("An Exception occured with baseURI. Please check the baseURI: "+e);
	}
	
}
private static RequestSpecification createRequest(String contenttype, String token, Map<String, String> params, 
		boolean log)
{
	RequestSpecification request;
	if(log)
	{
		request=RestAssured.given().log().all();
	}
	else
	{
		request=RestAssured.given();
	}
	
	if(token!=null)
	{
		request.header("Authorization", "Bearer "+token);
	}
	
	if(params!=null)
	{
		request.queryParams(params);
	}
	if(contenttype.equalsIgnoreCase("JSON"))
	{
		request.contentType(ContentType.JSON);
	}
	else if(contenttype.equalsIgnoreCase("XML"))
	{
		request.contentType(ContentType.XML);
	}
	else if(contenttype.equalsIgnoreCase("TEXT"))
	{
		request.contentType(ContentType.TEXT);
	}
	return request;	
}
private static Response getResponse(String httpmethod, RequestSpecification request,
		String basepath)
{
	return executeAPI(httpmethod, request,basepath);
}

private static Response executeAPI(String httpmethod, RequestSpecification request,
		String basepath)
{
	Response response=null;
	switch(httpmethod)
	{
	case "GET":
		response=request.get(basepath);
		break;
	case "POST":
		response=request.post(basepath);
		break;
	case "PUT":
		response=request.put(basepath);
		break;
	case "DELETE":
		response=request.delete(basepath);
		break;
		
		default:
			System.out.println("Only GET, POST, PUT & DELETE httpmethods are allowed");
			break;
	}
	return response;
}





}
