#Maven Profiles
This article explains the available profile and the steps executed with each profile

###Full build (Compile, Unit Test, Deploy and Functional Test)
mvn clean install

###Compile and Unit Test
mvn clean install -P unit-tests

###Compile, Deploy and Functional Test
mvn clean install -P run-apps-functional-tests

###Compile and Deploy
mvn clean install -P run-apps

###Compile and Functional Test
mvn clean install -P functional-tests