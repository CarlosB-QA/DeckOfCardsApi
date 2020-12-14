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
3. To execute all the tests in the project enter this command: `mvn test`
4. To run a specific set, for example DeckOfCardsApiPositiveTests, use this command: `mvn -Dtest=DeckOfCardsApiPositiveTests test`

Because this is a Maven Java project, the first time you run the commands to test, Maven will download and install all the dependencies necessary to run the project.

IDE (eclipse)
1. Clone the project to a local directory in the computer that will run this test.
2. Launch eclipse
3. Select to import a Maven project (make sure Maven is installed in eclipse which for the latest versions is installed by default)
4. Once imported, the project will install all the necessary dependencies listed in the pom.xml file. If this does not happen, right click on the project and select Maven>Update Project
5. Add the TestNG Library to the Build Path (if your eclipse version does not have TestNG installed, get it from the marketplace)
6. To execute all tests right click on the package that contains all the test cases: com.deckofcardsapi and select Run As>TestNG Test
7. To execute a particular test set, select one of the sets (positive/negative classes) that include your tests inside the com.deckofcardsapi package, right click. and select Run As>TestNG Test.
8. You can even run individual tests if you have TestNG version 7 or newer. Open the test class that contains your tests assigned with the annotation @Test in your eclipse editor. You will see two options underneath this annotation to run or debug that particular test. Select the option you want to use to execute.

Note:
There are other ways to set execution in TestNG, for example you could create an test configuration xml file, and there specify the tests you want to run, include, exclude methods, classes, sets, etc, set threads for parallel tests, send data as parameters for your tests, etc. TestNG also provides options to do data driven with the @DataProvider annotation. For time constraints these execution options have not been included on this test.
 
**Logs**

As the project runs, the console will show Logs for the beginning and end of the sets, and for each of the test methods that are running.
You can also find Logs for this projects in the Log folder at the root level.

**Note on failed test:**
 
The last test: inputInvalidCountValue is failing because there is a 500 status code thrown by the server. I am expecting a 200.
There is not enough info at this time to find out why the code is not able to handle the invalid input. The expected result on the test is that once a deck is created, 52 cards will exist, and because the Draw method should fail due to an invalid entry, the number of cards should remain at 52, and the Assert method should pass because of that. 
I will leave the failure to be recorded, and more research needs to be done when time permits. 
The research I would conduct to fix this issue includes:
1. Cloning the Deck of Cards Api project locally in my computer
2. Finding and fixing the code that throws the 500 code in this scenario
3. Forking the project for the approval process
4. Re testing when the changes make it to the Master repo  



