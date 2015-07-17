# AngularJs
Repository to learn AngularJs with Maven and Java EE rest service

### Required Software and Tools
* Java Version: Oracle Java 1.8.0_31 (Execute *java -version* in command line after installation)
* Apache Maven Version: 3.2.5 (Execute *mvn -version* in command line after installation)
* PhantomJS Browser: 1.9.8 (Execute *phantomjs --version* in command line after installation)
* Git Client: Any latest version (Execute *git --version* in command line after installation)
* Mozilla Firefox Browser: Any version
* Integrated Development Environment: Any version IntelliJ Idea or Eclipse

### Running full build
**mvn clean install**

### Running AngularJs unit test using Jasmine
**mvn jasmine:bdd -pl :angularjs-war**

Then go to http:localhost:8234 in browser

