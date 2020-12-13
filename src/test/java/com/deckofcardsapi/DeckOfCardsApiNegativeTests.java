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

public class DeckOfCardsApiNegativeTests {
	private JsonPath jp;
	private DeckOfCardsApiSupportMethods myRom;
	private String deckId;
	private HashMap<String,String> params;
	private Logs log;
	
	@BeforeClass
	public void setup() {
		myRom = new DeckOfCardsApiSupportMethods("https://deckofcardsapi.com/api/deck");
		log = new Logs(DeckOfCardsApiNegativeTests.class);
		log.createLog("info","##### Deck of Cards Negative Tests Start #####");
	}
	@Test(priority=10)
	public void createDeckAndDrawZeroCards() {
		log.createLog("info","--> createDeckDrawZero test method running");
		deckId = new JsonPath(myRom.createNewDeck()).get("deck_id");
		params = new HashMap<>();
		params.put("count", "0");
		jp = new JsonPath(myRom.drawCardsFromDeck(deckId,params));
		Assert.assertEquals(jp.getString("remaining"), "52");
	}
	@Test(priority=20)
	public void createDeckAndDrawAllCards() {
		log.createLog("info","--> createDeckDrawAll test method running");
		deckId = new JsonPath(myRom.createNewDeck()).get("deck_id");
		params = new HashMap<>();
		params.put("count", "52");
		jp = new JsonPath(myRom.drawCardsFromDeck(deckId,params));
		Assert.assertEquals(jp.getString("remaining"), "0");
	}
	@Test(priority=30)
	public void createDeckAndOverDraw() {
		log.createLog("info","--> createDeckOverDraw test method running");
		deckId = new JsonPath(myRom.createNewDeck()).get("deck_id");
		params = new HashMap<>();
		params.put("count", "53");
		jp = new JsonPath(myRom.drawCardsFromDeck(deckId,params));
		Assert.assertEquals(jp.getString("error"), "Not enough cards remaining to draw 53 additional");
	}
	@Test(priority=40)
	public void drawCardsOnEmptyDeck() {
		log.createLog("info","--> drawCardsOnEmptyDeck test method running");
		deckId = new JsonPath(myRom.createNewDeck()).get("deck_id");
		params = new HashMap<>();
		params.put("count", "52");
		jp = new JsonPath(myRom.drawCardsFromDeck(deckId,params));
		Assert.assertEquals(jp.getString("remaining"), "0");
		params.replace("count", "1");
		jp = new JsonPath(myRom.drawCardsFromDeck(deckId,params));
		Assert.assertEquals(jp.getString("error"), "Not enough cards remaining to draw 1 additional");
	}
	@Test(priority=50)
	public void inputInvalidCountValue() {
		log.createLog("info","--> verifyInvalidCountValue test method running");
		deckId = new JsonPath(myRom.createNewDeck()).get("deck_id");
		params = new HashMap<>();
		params.put("count", "count");
		jp = new JsonPath(myRom.drawCardsFromDeck(deckId,params));
		Assert.assertEquals(jp.getString("remaining"), "52");
	}
	@AfterClass
	public void tearDown() {
		log.createLog("info","##### Deck of Cards Negative Tests Ends #####");
	}
}
