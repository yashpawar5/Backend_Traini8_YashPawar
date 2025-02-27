Instructions for running this project locally:
1. Make sure MySQL server is installed on your system.
2. Run the following query on MySQL workbench or using the terminal:
    CREATE DATABASE traini8;
3. In application.properties file change username and password for MySQL server:
    spring.datasource.username=root
    spring.datasource.password=yourpassword
4. To build and run the application using maven run the following commands:
    mvn clean install
    mvn spring-boot:run


