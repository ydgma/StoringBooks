# StoringData

Simple project to test and learn more about storing data using hibernate and spring <br />

 MySQL create table script:  <br />

CREATE TABLE `book` ( <br />
  `bookType` varchar(10) DEFAULT NULL, <br />
  `wordCount` int DEFAULT NULL, <br />
  `bookID` int NOT NULL AUTO_INCREMENT, <br />
  `bookAsFile` mediumblob, <br />
  `bookName` varchar(40) DEFAULT NULL, <br />
  PRIMARY KEY (`bookID`)) <br />

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
* Add a rating and date finished columns
