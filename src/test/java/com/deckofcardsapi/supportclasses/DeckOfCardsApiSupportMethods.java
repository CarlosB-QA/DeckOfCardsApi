package com.deckofcardsapi.supportclasses;


import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

public class DeckOfCardsApiSupportMethods {
	private String baseUri;
	private Logs log = new Logs(DeckOfCardsApiSupportMethods.class);

	public DeckOfCardsApiSupportMethods(String baseUri) {
		this.baseUri= baseUri;
	}
	public String createNewDeck() {
		return given().baseUri(baseUri)
				.get("/new/").then().statusCode(200)
				.extract().response().asString();
	}
	public String createNewDeck(Map<String, String> params) {
		return given().baseUri(baseUri).params(params)
				.get("/new/").then().statusCode(200)
				.extract().response().asString();
	}
	public String drawCardsFromDeck(String deckId,HashMap<String,String>params) {
		return given().baseUri(baseUri).params(params)
				.get(deckId+"/draw/").then().statusCode(200)
				.extract().response().asString();
	}
}
