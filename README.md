# Membership Manager
This is a toy program which shows how to use Java, JDBC, SQLite and common design patterns to interact with databases.

Libraries used:
 * sqlite-jdbc

Build system: Apache Maven

Design Patterns Used:
 * Data Access Objects
 * State Machine

Steps to setup the build environment and run the project (run these commands from a terminal):
1. Install Apache Maven (to download libraries and build the project)
```shell
sudo apt install maven
```
2. Clone the git repository (this downloads a copy of the source code to the directory membership-manager):
```shell
git clone https://github.com/smithandrewl/membership-manager.git
```
3. Enter the source directory
```shell
cd membership-manager
```
4. Build the project:
```shell
mvn package
```

5. Run the project:
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

## Development ##
It is recommended to use IntelliJ IDEA Community to edit the project.

Install IntelliJ Community Edition on Ubuntu (from a terminal):
```
sudo snap install intellij-idea-community --classic
```
