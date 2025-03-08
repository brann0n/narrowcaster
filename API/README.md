[![Latest release](https://badgen.net/github/release/brann0n/narrowcaster)](https://github.com/brann0n/narrowcaster/releases)
[![Website narrowcaster-api.ba99.nl](https://img.shields.io/website-up-down-green-red/https/narrowcaster-api.ba99.nl.svg)](https://narrowcaster-api.ba99.nl/)  

[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](#)

[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)](#)
[![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)](#)
[![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](#)

# Narrow caster Dashboard
*Project for 'Advanced Java' Minor, made by Students*

## How to run
* Clone the project to a folder of your desire.
* Create a mysql database and run the script `narrowcaster.sql` that can be found in the API folder of the repository.
* Open the project with IntelliJ, and sync files with maven.
* Now update the `application.properties` file with credentials to your database like so: 
    ```properties
    database.user=[USERNAME]
    database.pass=[PASSWORD]
    database.url=jdbc:mysql://[ADDRESS]:[PORT]/[DB_NAME]
    database.driver=com.mysql.jdbc.Driver
    ```
* If you are not using mysql as your db driver, change those values for your respective db type.
* Now run the maven command `jetty:run`. If something is wrong with your database credentials a long error will be generated, scroll to the top to see the issue.
* Create default user if you have an empty user table. The username is `admin` and password is `changeme`.
    ```mysql
    INSERT INTO `users` 
    (`id`, `username`, `password`, `enabled`, `role`, `pfp_location`) 
    VALUES (NULL, 'admin', '$2a$10$6WuZxvmGulNvJTPqhSSwGuPUYfniQqb5t4J0zn.DQPY0CII2kkYwq',
    '1', 'ROLE_ADMIN', '/ava/avatar.jpg');
    ```
* Visit the testing location of the API (Jetty default: [localhost:8080](http://localhost:8080/)). On the default page will be a link to direct you to the Swagger.
* You can now use Swagger to test out the API.

---

## Available endpoints
These endpoints are available on the API.

* availabilities
* consultation_hours
* files
* logs
* media_slides
* rss_slides
* screens
* slideshows
* slideshow_variables
* test_slides
* users

## Api documentation by Swagger
This Api project uses swagger to further document actions on endpoints and data models that were used.
If you have completed the setup of the project, visiting the landings page would direct you to the location of Swagger.

