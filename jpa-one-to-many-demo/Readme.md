# Hibernate One to Many Mapping Example with Spring Boot and JPA

Read the Tutorial - https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/

## Setup the Application

1. Create a database named `hibernate_one_to_many_demo`.

2. Open `src/main/resources/application.properties` and change `spring.datasource.username` and `spring.datasource.password` properties as per your MySQL installation.

3. Type `mvn spring-boot:run` from the root directory of the project to run the application.


## Notes:
I have been working with hibernate for quite some time and I’ve realized that the best way to model a one-to-many relationship is to use just @ManyToOne annotation on the child entity.


