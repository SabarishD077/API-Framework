package com.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
	
public static String getSerializedJson(Object object)
{
	ObjectMapper mapper=new ObjectMapper();
	String jsonstring= null;
	try {
		jsonstring=mapper.writeValueAsString(object);
	} catch (JsonProcessingException e) {
		e.printStackTrace();
	}
	
	System.out.println("Converted Json string is :" +jsonstring  );
	
	return jsonstring;
}

}
