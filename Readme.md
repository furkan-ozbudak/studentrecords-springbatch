## Failure of dockerizing

I was able to create container for my mysql server but
I could not finish composing it with my spring boot app's container yet.
In order to not violate due date, I am uploading my project as it is.

## Functionality

Security and batch is working well.

## How to use

1. Uploaded source code needs to be imported by its' pom file.
2. Spring data source credentials(username and password for mySQL user)
needs to be changed from the application.properties file.
3. An empty database schema needs to be created and mentioned
in the data source url from the applicaiton.properties file.
(Hibernate will create the tables when application boot up.)
4. localhost:8080/students will redirect user to login. If user logs in
as an employee, he is not authorized to see the student list, access
denial will be thrown. If user logs in as an admin,
he is able to see the the student list.


## User credentials for the app:

User creation occurs in the EaLab1Application class.

1. username: admin@gmail.com   password: admin
2. username: employee@gmail.com    password: employee








