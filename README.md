# StoringData

Simple project to test and learn more about storing data using hibernate and spring <br />

 MySQLcreate table script:  <br />

CREATE TABLE `book` ( <br />
  `bookType` varchar(10) DEFAULT NULL, <br />
  `wordCount` int DEFAULT NULL, <br />
  `bookID` int NOT NULL AUTO_INCREMENT, <br />
  `bookAsFile` mediumblob, <br />
  `bookName` varchar(40) DEFAULT NULL, <br />
  PRIMARY KEY (`bookID`)) <br />

ensure there is a project.properties file unser src/main with the following properties <br />
db.user= <br />
db.password= <br />
db.url= <br />
jdbc.driver= <br />
