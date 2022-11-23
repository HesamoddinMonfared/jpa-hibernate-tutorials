# Hibernate One to Many Mapping Example with Spring Boot and JPA

Read the Tutorial - https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/

## Setup the Application

1. Create a database named `hibernate_one_to_many_demo`.

2. Open `src/main/resources/application.properties` and change `spring.datasource.username` and `spring.datasource.password` properties as per your MySQL installation.

3. Type `mvn spring-boot:run` from the root directory of the project to run the application.


## Notes:
The idea with bidirectional one-to-many association is to allow you to keep a collection of child entities in the parent, and enable you to persist and retrieve the child entities via the parent entity. This is made possible via Hibernate’s entity state transitions and dirty checking mechanism.