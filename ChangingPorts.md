# Changing Ports
This article explains the properties to change the wildfly server port and jasmin spec runner port

### Changing wildfly server port
Change the wildfly port to 9080 by setting the following properties.
Default port of wildfly is 8080.
Note: All these properties has to be set for the changes to take effect
mvn clean install -DserverPortOffset=1000 -DserverHttpPort=9080 -DserverManagementPort=10990 -DserverDebugPort=9787

### Changing jasmine spec runner port
Change the jasmine spec runner port to 8334 by setting the following property.
Default port of jasmine spec runner is 8234.
mvn jasmine:bdd -pl :angularjs-war -Djasmine.runner.port=8334

