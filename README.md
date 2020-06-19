# StoringData

Simple project to test and learn more about storing data using hibernate and spring <br />

 MySQL create table script:  <br />

``` CREATE TABLE `book` (
  `bookType` varchar(10) DEFAULT NULL,
  `wordCount` int DEFAULT NULL,
  `bookID` int NOT NULL AUTO_INCREMENT,
  `bookAsFile` mediumblob,
  `bookName` varchar(40) DEFAULT NULL,
  `bookRating` int DEFAULT NULL,
  `dateAdded` date DEFAULT NULL,
  `bookReview` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`bookID`)
) ```

Ensure there is a project.properties file under src/main with the following properties: <br />
db.user= <br />
db.password= <br />
db.url= <br />
jdbc.driver= <br />

Tools used to run: Apache Tomcat server 9 and Smart Tomcat plugin for Intellij.

TODO:
* Use a seperate database when testing DAO.
* Create a teardown to clear test data created. 
* Add css to view pages
* implement functionality to view/edit and delete books
