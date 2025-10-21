# Backend para Aplicación Web de una empresa Constructora

Proyecto generado usando [Spring Initializr](https://start.spring.io/)

Backend para la aplicación web de una empresa constructora, el frontend está desarrollado el Angular.

Este proyecto es desarrollado como parte del curso <b>Soluciones Web y Aplicaciones Distribuidas</b> con <b>NRC 3423</b>, correspondiente al <b>período UPN 2025-2</b>
- ARQUITECTURA: n-capas
## Versiones

- Project: Maven
- Language: Java
- Spring Boot: 3.5.5
- Packaging: jar
- Java: 21

## Documentación
La API debe evolucionar según el modelo de madurez de Richardson, revise la documentación de [Richardson Maturity Model](https://martinfowler.com/articles/richardsonMaturityModel.html) según Martin Fowler

## Base de datos
Revise el motor de base de datos y la cadena de conexión a su base de datos en el archivo `application.properties` y actualízelo según corresponda. El proyecto está configurado para trabajar con MySQL, para cambiar de motor de base de datos actualice el archivo `pom.xml`

Las dependencia incluida es:
```
    <!-- Enables MySQL database connection -->
    <!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>9.4.0</version>
    </dependency>
```

y en el archivo `application.properties` agregue la cadena de conexión:
```
    # JPA / Hibernate settings
    spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
    spring.jpa.database=mysql
    spring.jpa.show-sql=false
    spring.jpa.generate-ddl=true
    spring.jpa.hibernate.ddl.auto=update
    
    # Database connection
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/constructapp
    spring.datasource.username=your_user
    spring.datasource.password=your_password
```

Para una conexión a postgresql considere la siguiente configuración en `pom.xml`
```
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
```
Y la configuración de `application.properties`
```
    server.port=9090
    spring.jpa.database=postgresql
    spring.jpa.show-sql=false
    spring.jpa.hibernate.ddl-auto=update
    
    spring.datasource.driver-class-name=org.postgresql.Driver
    #Desde Spring Boot 3.1
    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
    spring.datasource.url=jdbc:postgresql://localhost:5432/constructapp
    spring.datasource.username=your_user
    spring.datasource.password=your_password
```
Para mapeo de Modelo y DTO, pueden usar [ModelMapper](https://modelmapper.org/), [MapStruct](https://mapstruct.org/), o alguna biblioteca que considere conveniente.
En el proyecto se utiliza modelMapper, incluir en el `pom.xml`
```
    <!-- https://mvnrepository.com/artifact/org.modelmapper/modelmapper -->
    <dependency>
        <groupId>org.modelmapper</groupId>
        <artifactId>modelmapper</artifactId>
        <version>3.2.4</version>
    </dependency>
```

Jakarta Validation
```
    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
    <version>3.5.5</version>
    </dependency>
```