# employee-api

Simple CRUD using a RESTfull application, where we knowingly call backend. The other part, frontend has not yet been implemented, but soon I hope to start it and make it available. In short, the backend is responsible for providing a web service that can be called through a URL and responding to what was requested in JSON.

<b>Technologies and Prerequisites</b>
 * Java 1.8
 * Maven 3.3.9
 * Spring Tool Suite – Version 3.8.4.RELEASE
 * Spring Boot Start: 2.1.3.RELEASE

<b>Installing and Step to do</b>
* Create Spring Boot project & add Dependencies 
* Configure Spring JPA
* Create DataModel Class Employee
* Create Spring JPA Repository Interface “EmployeeRepository”
* Create Web Controller “EmployeeController” 
* Create MySQL table 
* Run Spring Boot Application & Enjoy Result

<b>Class and Interfaces and methods</b>
* **Employee** class corresponds to entity and table employee.
* **EmployeeRepository** is an interface extends CrudRepository, will be autowired in CustomerController for implementing repository methods and custom finder methods.
* **EmployeeController** is a REST Controller which has request mapping methods for RESTful requests such as:
  getAllEmployee, 
  postEmployee,
  deleteEmployee, 
  deleteAllEmployee, 
  findByAge,
  updateEmployee.
  
* Configuration for Spring Datasource and Spring JPA properties in **application.properties**
* Dependencies for Spring Boot and MySQL in **pom.xml**

<b>application.properties</b>

Configuration for Spring Datasource & JPA properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/employeedb?useSSL=false
spring.datasource.username=root
spring.datasource.password=12xyz
spring.jpa.generate-ddl=true
```

<b>Our Spring Boot Server can work with MySQL Database and provides APIs:<b>
```  
GET /api/employees/: get all employees
GET /api/employees/{id}: get a employeesby id
GET  /api/employees/age/{age}: find all employees by age
POST  /api/employees/create: save a employees
PUT  /api/employees/{id}: update a employeesby id
DELETE  /api/employees/{id}: delete a employeesby id
DELETE /api/employees/: delete all employees
```  
