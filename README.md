# UrlHashing
This is a Spring Boot project that aims to implement a URL hashing system to mitigate the potential negative impact caused by formatters. It addresses challenges such as the inability to restrict URL length and the need to consider query parameters.

Summary:
1. In my application, I have utilized the H2 in-memory database to perform CRUD operations. The H2 database dependency is included in the project as follows:
<!-- H2 Database (in-memory database) -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>

2. I have also created an entity class called HashedUrl, which represents the hashed URLs within the application.
3. To handle database operations related to HashedUrl entities, I have implemented a HashedUrlRepository interface that extends JpaRepository.
4. Additionally, I have developed a UrlHashingService to manage the logic for generating and retrieving hashed URLs.
5. To handle requests related to URL hashing, I have designed a REST API controller named HashingController.

TODO:
1. An extra layer of security can be implemented by incorporating tokens to regulate access to the hashed URL.
2. The user interface can be seamlessly integrated to enhance the ease of utilizing this feature.
3. Swagger can be incorporated into the project to automatically generate comprehensive documentation for RESTful web services. This documentation will provide detailed information about the available endpoints, request/response formats, and any required parameters.
4. To ensure code quality and functionality, JUnit can be integrated into the project to perform automated testing before deploying. This allows developers to write unit tests to verify the correctness of individual components or modules independently. By running these tests, potential issues and bugs can be identified early on, leading to more reliable and robust code.
