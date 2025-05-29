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

