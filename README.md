Instructions for running this project locally:
1. Clone this repo using the following command:

   git clone https://github.com/yashpawar5/Backend_Traini8_YashPawar.git
2. Make sure MySQL server is installed on your system.
3. Run the following query on MySQL workbench or using the terminal:
   
    CREATE DATABASE traini8;
4. In the application.properties file, update the MySQL username and password:
   
    spring.datasource.username=root
   
    spring.datasource.password=yourpassword
5. To build and run the application using maven run the following commands:
   
    mvn clean install
   
    mvn spring-boot:run


