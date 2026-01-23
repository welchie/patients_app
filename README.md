# Patients App
Spring Boot Web App to display patients and their actions.



## How to build
To build the application run the following command

```bash
./mvnw clean install
```

## Configuring the database connection
The database connection is configured in application.properties file.
Configure the following parameters appropriately


<b>spring.jpa.properties.hibernate.dialect<br>
spring.datasource.url<br>
spring.datasource.username<br>
spring.datasource.password<br></b>

## Running the application
You can run the application by executing the following command

```bash
java -jar target/patients-0.0.1-SNAPSHOT.jar
```

## Accessing the Web Pages

You can access the web page by navigating to
[http://localhost:8080](http://localhost:8080 "Localhost")

You will be presented a list of patients.

To see the extended patient details click on the details icon <img height="40" src="/Users/chriswelch/workspace/interview_task_agentis/patients/src/main/resources/static/images/search.jpg" width="40"/>
