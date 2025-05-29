### JPA Entities
* JPA entities are usually put in a package called domain or model.
* Each JPA entity must be annotated with @Entity
* Each JPA entity must have an id field which is annotated with @Id
* Think of JPA Entities as tables / schema in SQL
<br><br>

### Equality in Hibernate
* We have to implement a equals() and a hashCode() method to prevent any leakages.
* The default equals() and hashCode() method we get from Java will not suffice for this.