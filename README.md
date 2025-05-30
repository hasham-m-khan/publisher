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
<br><br>

### Introduction to Spring MVC
![image](https://i.imgur.com/Pd13Au6.png)
<br>
* **MVC** stands for **M**odel, **V**iew, **C**ontroller.
  * MVC is a programming paradigm on how to develop applications.<br><br>
  * **Model**
    * Is a simple POJO with collection of preoperties which may or may not be used by the view.<br><br>
  * **View**
    * Data as requested by the client. Implemented with JSP, Thymeleaf, Jackson, etc. Can be HTML, JSON, XML, text, etc.<br><br>
  * **Controller**
    * Java class implemented to handle request mapping. 
    * Should be a "traffic cop" and contain minimal business logic. 
    * Typically works in conjunction with a service, which contains business logic.<br><br>
  * When a client sends a request, that request is handled by the controller.
    * The **controller** is responsible for handling requests and facilitating responses.
    * The controller may or may not need to invoke some business logic on the backend.
    * The result of a controller is the population of a **model**. This is usually a POJO, or some type or data structure.
  * The model is provided to the **view**.
  * The view layer handles the rendering of the model or how the client requests the data.

![image](https://i.imgur.com/7HZRKBt.png)
<br><br>

### Configuring Spring Controllers
***Purpose:*** To associate a specific method with a specific request path.
* Annotate the Controller Class with ```@Controller```.
  * This will register the class as a Spring Bean and as as Controller in Spring MVC.
* To map methods to http request paths, use ```@RequestMapping```.
* A good practice is to put controllers in a new package named "controllers.'
* The controller returns a string that denotes the view name.
* The ```@RequestMapping``` method must have a ```Model``` as a parameter because in an MVC paradigm the Model gets returned to the view.
* The ```Model``` will contain the data that you want to pass to the view.
  * Data is passed to the ```Model``` through the ```addAttribute()``` method.
  * ```Model.addAttribute()``` has two parameters, one for the attribute name, and another for the data that will be passed to the view.
<br><br>


