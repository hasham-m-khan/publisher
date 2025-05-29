### JPA Entities
* JPA entities are usually put in a package called domain or model.
* Each JPA entity must be annotated with @Entity.
* Each JPA entity must have an id field which is annotated with @Id.
* Think of JPA Entities as tables / schema in SQL.
<br><br>

### Equality in Hibernate
* We have to implement a equals() and a hashCode() method to prevent any leakages.
* The default equals() and hashCode() method we get from Java will not suffice for this.
<br><br>

### Spring Data Repositories
1. Create a new package called "repositories."
2. Create an interface in the package for your JPA entities.
   * The interface must extend the CrudRepository<JPAEntity, idType> interface.
<br><br>

### Initializing Data with Spring
* Create a package called "bootstrap."
* Add a class that will be initializing the data in the bootstrap package.
  * This class must implement the CommandLineRunner interface.
  * This class must also override the run() method that is declared in the CommandLineRunner interface.
  * Be sure to constructor inject your repos in the class so that you can add data to them through the run() method.
<br><br>

### Publisher Relationships
* Create a JPA entity in the domain package.
* Establish relationships with other entities in the JPA entity.
* Create a repository for the JPA entity in the repositories package.
* Finally, initialize data through the CommandLineRunner class.
<br><br>

### H2 Database Console
* Enable the H2 console in your `application.properties`.
  * To enable the H2 server: `spring.h2.console.enabled=true`
* The H2 dashboard is located at `yourdomain.com/h2-console`.
* Look for a message in your terminal that says `H2 console available at ... 'jdbc.h2.mem:testdb'`
  * `jdbc.h2.mem:testdb` is the url of the database.
  * `mem` denotes that the database is in memory.
  * `testdb` is the schema name.
* Navigate to the H2 console endpoint.
* Ensure that the `JDBC URL` matches the url listed in the terminal.
  * If the `JDBC URL` does not match the url of the database, H2 will create a new database for the URL that was listed in `JDBC URL`.
    * This means that you will not be able to see any data for your database if you enter the wrong JDBC URL. 
