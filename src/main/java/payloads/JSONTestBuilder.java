package payloads;
import java.util.ArrayList;

import pojoClasses.Googleplace;
import pojoClasses.location;

public class JSONTestBuilder {
	
	
	public Googleplace payload(int accuracy, String address, String language) {
		
		Googleplace obj = new Googleplace();
		obj.setAccuracy(accuracy);
		obj.setAddress(address);
		obj.setLanguage(language);
		
		obj.setName("Frontline house");
		obj.setPhone_number("(+91) 983 893 3937");
		obj.setWebsite("http://google.com");
		
		ArrayList<String> array = new ArrayList<String>();
		array.add("shoe park");
		array.add("shop");
		array.add("park");
		
		obj.setTypes(array);
		
		location locat = new location();
		locat.setLat(-38);
		locat.setLng(30);
		
		obj.setLocation(locat);
		
		return obj;
		
	}
	
	public String deletePayload(String Place_id) {
		
		return "{\r\n" + 
				"    \"place_id\":\""+Place_id+"\"  \r\n" + 
				"}\r\n" + 
				"";
	}

}
