Feature: Check the Add Place API 

Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
	Given Add Place Payload with "<accuracy>" "<address>" "<language>"
	When User call "AddPlaceAPI" using "POST" request
	Then API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_Id created maps to "<language>" using "GetPlaceAPI"

Examples:
		|accuracy	|address	|language	|
		|10			|Address 1	|English	|
		

@DeletePlace	
Scenario: Verify if Delete Place functionality is working

	Given DeletePlace Payload
	When User call "DeletePlaceAPI" using "DELETE" request
	Then API call got success with status code 200
	And "status" in response body is "OK"