# StoringData

Simple project to test and learn more about storing data using hibernate and spring

/// MySQLcreate table script \\\
CREATE TABLE `book` (
  `bookType` varchar(10) DEFAULT NULL,
  `wordCount` int DEFAULT NULL,
  `bookID` int NOT NULL AUTO_INCREMENT,
  `bookAsFile` mediumblob,
  `bookName` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`bookID`)
)

/// ensure there is a project.properties file unser src/main with the following properties \\\
db.user=
db.password=
db.url=
jdbc.driver=
