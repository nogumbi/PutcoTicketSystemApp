# Putco Ticketing System

***Putco Web Based App***

Electronic ticketing system which will allow putco commuters to refill their bus tag on a web based application.


* You can run the program using the instructions in *To Run* below.
* You can test technical correctness by running the unit tests as in the section *To Test* below.


****Build, Test & Run****

***To install Intellij and Maven***

**run the setup.sh script**

You may use your desired IDE to run your code and tests, but alternatively you can use the Maven build tool:

First ensure you are in the root directory of the project

* To compile your code, run: *mvn compile*

* To run the tests: *mvn test*

* To run your application: *mvn compile exec:java*

### To Run the USSD

* `python3 putcoussd.py`
* follow the input prompts to get the desired output

### To Test

* To run all the unittests: `python3 -m unittest test_putco.py`
* To run a specific step's unittest, e.g step *1*: `python3 -m unittest test_putco.MyTestCase.numberofdigits`
