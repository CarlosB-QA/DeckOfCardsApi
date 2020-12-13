package com.deckofcardsapi;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.deckofcardsapi.supportclasses.DeckOfCardsApiSupportMethods;
import com.deckofcardsapi.supportclasses.Logs;

import io.restassured.path.json.JsonPath;

public class DeckOfCardsApiPositiveTests {
	private JsonPath jp;
	private DeckOfCardsApiSupportMethods myRom;
	private HashMap<String,String> params;
	private String deckId;
	private Logs log;
	
	@BeforeClass
	public void setup() {
		myRom = new DeckOfCardsApiSupportMethods("https://deckofcardsapi.com/api/deck");
		log = new Logs(DeckOfCardsApiPositiveTests.class);
		log.createLog("info","##### Deck of Cards Positive Tests Start #####");
	}
	@Test(priority=10)
    public void createNewDeck() {
		log.createLog("info","--> createNewDeck test method running");
		jp = new JsonPath(myRom.createNewDeck());
		Assert.assertEquals(jp.getString("remaining"), "52");
    }
	@Test(priority=20)
	public void createNewDeckWithJoker() {
		log.createLog("info","--> createNewDeckWithJoker test method running");
		params = new HashMap<>();
		params.put("jokers_enabled", "true");
		jp = new JsonPath(myRom.createNewDeck(params));
		Assert.assertEquals(jp.getString("remaining"), "54");
    }
	@Test(priority=30)
	public void drawCardsFromDeck() {
		log.createLog("info","--> drawCardsFromDeck test method running");
		deckId = new JsonPath(myRom.createNewDeck()).get("deck_id");
		params = new HashMap<>();
		params.put("count", "2");
		jp = new JsonPath(myRom.drawCardsFromDeck(deckId,params));
		Assert.assertEquals(jp.getString("remaining"), "50");
    }
	@AfterClass
	public void tearDown() {
		log.createLog("info","##### Deck of Cards Positive Tests End #####");
	}
}
