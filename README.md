# Membership Manager
This is a toy program which shows how to use Java, JDBC, SQLite and common design patterns to interact with databases.

Libraries used:
 * sqlite-jdbc

Build system: Apache Maven

Design Patterns Used:
 * Data Access Objects
 * State Machine

To Build:
```shell
mvn package
```

To Run:
```shell
mvn exec:java -Dexec.mainClass=bike.rusty.membershipmanager.App
```

Example Output:
```
                       _                   _     _
  /\/\   ___ _ __ ___ | |__   ___ _ __ ___| |__ (_)_ __        
 /    \ / _ \ '_ ` _ \| '_ \ / _ \ '__/ __| '_ \| | '_ \  
/ /\/\ \  __/ | | | | | |_) |  __/ |  \__ \ | | | | |_) |   
\/    \/\___|_| |_| |_|_.__/ \___|_|  |___/_| |_|_| .__/     
                                                  |_|            
                                                                 
       /\/\   __ _ _ __   __ _  __ _  ___ _ __                 
      /    \ / _` | '_ \ / _` |/ _` |/ _ \ '__|               
     / /\/\ \ (_| | | | | (_| | (_| |  __/ |                  
     \/    \/\__,_|_| |_|\__,_|\__, |\___|_|               
                           |___/                                 
    Welcome to club 'Unkown' Please enter a number:
               1. Administration
               2. Members
               3. Classes
               4. Exit
```
