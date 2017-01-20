# rover
A simple Maven project, using AngularJS and a RESTful (Jersey-JAX-RS).
Where position and command coordinates are inserted, in order to receive the final position of the object in space.

# update
Collision control - Rovers can not be released in the same place, and can not cross (stop and ignores the rest of the instructions)

## Installation
Recommended use of Maven.

## Dependencies
```
		<!-- javax: XML binding -->
        <dependency>
            <groupId>javax.xml</groupId>
            <artifactId>jaxb-api</artifactId>
            <version>2.1</version>
        </dependency>

        <!-- RESTful web service: Jersey -->
        <dependency>
            <groupId>com.sun.jersey</groupId>
            <artifactId>jersey-server</artifactId>
            <version>1.17.1</version>
        </dependency>
        <dependency>
            <groupId>com.sun.jersey</groupId>
            <artifactId>jersey-servlet</artifactId>
            <version>1.17.1</version>
        </dependency>
        <dependency>
            <groupId>com.sun.jersey</groupId>
            <artifactId>jersey-json</artifactId>
            <version>1.17.1</version>
        </dependency>


        <!-- Unit testing -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
```		
## Tests
Tested on Tomcat v9.0 Server at localhost