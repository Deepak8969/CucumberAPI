package Utilities;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;







public class Utils {
	
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecificationBuilder() throws IOException, ConfigurationException {
		
		if(req==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(getBaseURL("BaseURL")).setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.addQueryParam("key", "qaclick123").build();
		
		return req;
		}
		
		return req;
	}
	
	public String getBaseURL(String key) throws IOException, ConfigurationException {
		
		PropertiesConfiguration prop = new PropertiesConfiguration("config//environment.properties");
		return prop.getString(key);
		
//		Properties prop =new Properties();
//		FileInputStream fis =new FileInputStream("/API_Cucumber_Framework/src/test/resources/config/environment.properties");
//		prop.load(fis);
//		return prop.getProperty(key);
	}
	
	public String getJsonValue(Response response,String key) {
		
		JsonPath js = new JsonPath(response.asString());
		String value = js.get(key);
		return value;
		
		
	}
	

}
