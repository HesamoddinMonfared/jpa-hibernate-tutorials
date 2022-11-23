# Hibernate Many to Many Mapping Example with Spring Boot and JPA

Read the Tutorial - https://www.callicoder.com/hibernate-spring-boot-jpa-many-to-many-mapping-example/

## Setup the Application

1. Create a database named `hibernate_many_to_many_demo`.

2. Open `src/main/resources/application.properties` and change `spring.datasource.username` and `spring.datasource.password` properties as per your MySQL installation.

3. Type `mvn spring-boot:run` from the root directory of the project to run the application.


## NOTES:
We use @ManyToMany annotation to create a many-to-many relationship between two entities. In a bi-directional association, the @ManyToMany annotation is used on both the entities but only one entity can be the owner of the relationship.

The entity that specifies the @JoinTable is the owning side of the relationship and the entity that specifies the mappedBy attribute is the inverse side.