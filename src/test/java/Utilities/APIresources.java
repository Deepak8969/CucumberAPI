package Utilities;

public enum APIresources {
	
	AddPlaceAPI("maps/api/place/add/json"),
	GetPlaceAPI("maps/api/place/get/json"),
	DeletePlaceAPI("maps/api/place/delete/json");
	
	String resource;
	
	
	APIresources(String resource){
		this.resource = resource;
	}
	
	public String getResource() {
		
		return resource;
	}

}
