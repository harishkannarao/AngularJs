# AngularJs
Repository to learn AngularJs with Maven and Java EE rest service

### Required Software and Tools
* Java Version: Oracle Java 1.8.0_31 (Execute **_java -version_** in command line after installation)
* Apache Maven Version: 3.2.5 (Execute **_mvn -version_** in command line after installation)
* PhantomJS Browser: 1.9.8 (Execute **_phantomjs --version_** in command line after installation)
* Git Client: Any latest version (Execute **_git --version_** in command line after installation)
* Mozilla Firefox Browser: Any version
* Integrated Development Environment: Any version IntelliJ Idea or Eclipse

### Running full build
**mvn clean install**

### Running AngularJs unit test using Jasmine
**mvn jasmine:bdd -pl :angularjs-war**

Then go to **_http:localhost:8234_** in browser

