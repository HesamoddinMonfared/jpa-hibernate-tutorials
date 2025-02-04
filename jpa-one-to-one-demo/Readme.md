# Hibernate One to One Mapping Example with Spring Boot and JPA

Read the Tutorial - https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-one-mapping-example/

## Setup the Application

1. Create a database named `hibernate_one_to_one_demo`.

2. Open `src/main/resources/application.properties` and change `spring.datasource.username` and `spring.datasource.password` properties as per your MySQL installation.

3. Type `mvn spring-boot:run` from the root directory of the project to run the application.

## one-to-one relationship
A one-to-one relationship is defined using JPA’s @OneToOne annotation. It accepts several attributes. Let’s understand what those attributes are meant for -

fetch = FetchType.LAZY - Fetch the related entity lazily from the database.

cascade = CascadeType.ALL - Apply all cascading effects to the related entity. That is, whenever we update/delete a User entity, update/delete the corresponding UserProfile as well.

mappedBy = “user” - We use mappedBy attribute in the User entity to tell hibernate that the User entity is not responsible for this relationship and It should look for a field named user in the UserProfile entity to find the configuration for the JoinColumn/ForeignKey column.

In a bi-directional relationship, we specify @OneToOne annotation on both the entities but only one entity is the owner of the relationship. Most often, the child entity is the owner of the relationship and the parent entity is the inverse side of the relationship.

The owner of the relationship contains a @JoinColumn annotation to specify the foreign key column, and the inverse-side of the relationship contains a mappedBy attribute to indicate that the relationship is mapped by the other entity.