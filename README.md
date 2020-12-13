# Deck of Cards API Test

The purpose for this project is to demonstrate API test automation on the Deck of Cards API. You can find the API instructions on Deck of Cards here:
`http://deckofcardsapi.com`

The github repository for Deck of Cards API can also be found here:
`https://github.com/crobertsbmw/deckofcards`

**Test Dependencies**

In order to execute the automated tests for the Deck of Cards API you will need the following software installed on the computer where these tests will be executed:

- Java SDK 8
- Maven 3.6.3 or better

**Test Details**

There are two Test Sets that will test the Deck of Cards API:

- DeckOfCardsApiPositiveTests
- DeckOfCardsApiNegativeTests

The positive set is geared towards a sanity check, just to verify if the API is running. This one contains 3 tests:

- createNewDeck
- createNewDeckWithJoker
- drawCardsFromDeck

The negative test contains scenarios that are intended to make the application fail, so we can observe and inspect the results of the failures. These are the tests in this set:

- createDeckAndDrawZeroCards
- createDeckAndDrawAllCards
- createDeckAndOverDraw
- drawCardsOnEmptyDeck
- inputInvalidCountValue

**Test Executions Instructions**

The tests on this project can be executed locally using command line instructions on a terminal. If you prefer, you can use an IDE like  elipse or Intellij, however running the project on an IDE is optional. The project is ready to be placed on an environment, or computer, and once the dependencies have been installed, the test can run with the instructions below.

Command Line
1. Clone the project to a local directory in your computer
2. Launch command line terminal
3. Enter these instructions: mvn clean test

Because this is a Maven Java project, the first time you run the commands to test, Maven will download and install all the dependencies necessary to run the project.

IDE (eclipse)
1. Clone the project to a local directory in the computer that will run this test.
2. Launch eclipse
3. Select to import a Maven project
4. Once imported, the project will install all the necessary dependencies listed in the pom.xml file. If this does not happen, right click on the project and select Maven>Update Project
5. Add the TestNG Library to the Build Path (if your eclipse version does not have TestNG installed, get it from the marketplace)

**Logs**

As the project runs, the console will show Logs for the beginning and end of the sets, and for each of the test methods that are running.
You can also find Logs for this projects in the Log folder at the root level.

Note: The last test: inputInvalidCountValue is failing because there is a 500 status code thrown by the server. I am expecting a 200.
There is not enough info at this time to find out why the code is not able to handle the invalid input. The expected result on the test is that once a deck is created, 52 cards will exist, and because the Draw method should fail due to an invalid entry, the number of cards should remain at 52, and the Assert method should pass because of that. 
I will leave the failure to be recorded, and more research needs to be done when time permits.



