# DNA Mutant Detector

This project is for the MeLi Exam. It implements a Mutant DNA detector, where the client can push a DNA genome and get if there is a mutant or a human.

It adds persistence, so each genome is saved with its corresponding evaluation to a database, and it can be retrieved as an statistics JSON object with the amount of Mutants and Humans, and with the rate (how many mutans per human there are).

It adds some UT using JUnit, with a 78% of coverage, but it doesn't test the REST Api it self, and it also does not mocks the database.

## Prerequisites

To run the project you should have your environment configured as follows:

* Maven
* Tomcat
* OpenJDK
* MySQL
* Eclipse

## Steps to run the project

### 1. The database setup

* In MySQL you need to import the dna_registry.sql

### 2. Environment variables

It needs to be some ENV VARIABLES with the settings to connect to the Data Base

* **MYSQL_HOST**: Usually *localhost*
* **MYSQL_PORT**: For MySQL it should be *3306*
* **MYSQL_USER**: The user to connect to the server
* **MYSQL_PASS**: The password to connect to the server

### 3. Postman

It could be other App to test APIs.

You can import to postman the JSON included in the REPO, there you will get some endpoints to test.

* [POST]/mutant: Accepts an object with the DNA to check
  The response will be 200 if the DNA corresponds to a mutant, 403 if the DNA corresponds to a human, 400 for a malformed DNA, 302 if you already checked the DNA, 500 if there is some error in the server
* [GET]/stats
  This request will respond with a JSON summarizing the mutants DNA count, the humans DNA count and the rate.
  
## Testing the API in the cloud
  
Using the same settings from Postamn, you should change the host in the request with the IP where the program is deployed (AWS EC2 ubuntu instance) 3.95.179.249