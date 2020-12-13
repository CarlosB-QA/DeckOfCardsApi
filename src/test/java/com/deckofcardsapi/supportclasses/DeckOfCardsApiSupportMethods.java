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
		try {
			String response = given().baseUri(baseUri)
					.get("/new/").then().statusCode(200)
					.extract().response().asString();
			return response;
		} catch (Exception e) {
			log.createLog("error", "Could not create a new deck of cards. Verify API Request, and stack trace.");
			e.printStackTrace();
			return "";
		}
	}
	public String createNewDeck(Map<String, String> params) {
		try {
			String response = given().baseUri(baseUri).params(params)
					.get("/new/").then().statusCode(200)
					.extract().response().asString();
			return response;
		} catch (Exception e) {
			log.createLog("error", "Could not create a new deck of cards with params. Verify API Request, and stack trace.");
			e.printStackTrace();
			return "";
		}
	}
	public String drawCardsFromDeck(String deckId,HashMap<String,String>params) {

		try {
			String response = given().baseUri(baseUri).params(params)
					.get(deckId+"/draw/").then().statusCode(200)
					.extract().response().asString();
			return response;
		} catch (Exception e) {
			log.createLog("error", "Could not draw cards from the deck. Verify API Request, and stack trace.");
			e.printStackTrace();
			return "";
		}
	}
}
