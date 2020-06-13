package com.api.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.pojo.user;
import com.api.restclient.RestClient;
import com.api.util.ExcelUtil;

import io.restassured.response.Response;

public class UpdateUserTest {
	
	String baseURI= "https://gorest.co.in";
	String basepath= "/public-api/users/26222";
	String token= "3s3xRgt7IrZM7jpORC2rqk-r-kLiDGCrgOji";
	
@DataProvider
public Object[][] getUserData()
{
	Object userdata[][]= ExcelUtil.getTestData("updatedata");
	return userdata;
}

@Test(dataProvider="getUserData")
public void UpdateUserApiPutTest(String firstname, String lastname, String gender,
		String dob, String email, String phonenumber, String website, String address, String status)
{
	user user=new user(firstname, lastname, gender, dob, email, phonenumber, website, address, status);
	//user user=new user("Anushka1", "Sharma", "female", "01-01-1987", "anusharmaK@gmail.com",
	//		"+1-999-9876-987", "https://www.google.com", "new avenue Coimbatore", "active");
	Response response=RestClient.doPut("JSON", baseURI, basepath, token, null, true, user);
	System.out.println(response.prettyPrint());
	System.out.println("Response code is :" +response.statusCode());
	System.out.println("*********Data Updated Successfully **********");
}


}
