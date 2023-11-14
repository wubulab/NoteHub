# NoteHub
"Note Hub" is a note management project built using Java 18, Spring Core, Spring Boot, Hibernate and MongoDb technologies. The project allows users to create, read, update and delete their notes through a web interface. The main components of the project include:
API (Application Programming Interface): This is an external system interface that allows users to interact with the system through HTTP requests. The API is implemented using Spring Boot and REST API.
Services: Services are internal components of the system responsible for performing basic note operations, such as creating, reading, updating, and deleting notes. Services are also responsible for user authorization.
Repositories: Repositories are responsible for storing data about notes in a database. This project uses the MongoDb database, and Hibernate is used for data access.
Database: A PostgreSQL database is used to store information about user notes.
JWT-tokens: JWT-tokens are used for user authorization, which ensure security and user identification.
Configuration: System settings are defined using the application.properties file or other configuration files used in Spring Boot.

The project is developed by 2 java developers(wubulab, Archimemius) and 1 android developer(BohdanBalukh).
