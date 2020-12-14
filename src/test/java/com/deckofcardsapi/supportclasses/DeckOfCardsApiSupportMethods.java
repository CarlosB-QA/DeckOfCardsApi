package com.deckofcardsapi.supportclasses;


import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

public class DeckOfCardsApiSupportMethods {
	private String baseUri;
	
	public DeckOfCardsApiSupportMethods(String baseUri) {
		this.baseUri= baseUri;
	}
	public String createNewDeck(String resource) {
		return given().baseUri(baseUri)
				.get(resource).then().statusCode(200)
				.extract().response().asString();
	}
	public String createNewDeck(String resource, Map<String, String> params) {
		return given().baseUri(baseUri).params(params)
				.get(resource).then().statusCode(200)
				.extract().response().asString();
	}
	public String drawCardsFromDeck(String resource, String deckId,HashMap<String,String>params) {
		return given().baseUri(baseUri).params(params)
				.get(deckId+resource).then().statusCode(200)
				.extract().response().asString();
	}
}
