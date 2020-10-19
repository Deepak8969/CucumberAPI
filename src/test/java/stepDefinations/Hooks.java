package stepDefinations;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;

import io.cucumber.java.Before;

public class Hooks {
	
	AddPlaceStepDefination obj = new AddPlaceStepDefination();
	
	@Before("@DeletePlace")
	public void createPlace() throws NumberFormatException, ConfigurationException, IOException {
		
		if(AddPlaceStepDefination.place_id==null)
		{
	
		obj.add_Place_Payload_with("10","New Address","Hindi");
		obj.user_call_using_request("AddPlaceAPI", "POST");
		obj.verify_place_Id_created_maps_to_using("Hindi", "GetPlaceAPI");
		}
	}

}
