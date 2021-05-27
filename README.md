# Learning SpringBoot with JAVA
## Outline:
    - Learning spring boot for my [[Tencent internship]]
    -  https://github.com/cyu60/learning-springboot
## Motivation
    - To learn the basics of [[Spring Boot]], understanding how the framework runs ontop of JAVA
    - Learn how to use [[Spring Boot]] to manipulate [[RESTful API]] for persistence of data
    - Learn about how [[database]] can be used in conjunction to [[Spring Boot]] to create good models
## Log:
    - [[May 20th, 2021]]
        - Got to work on the basics of spring boot
        - Learned about how to implement the MVC framework in IntelliJ to run a web page on the local browser
        - Learned about AutoWiring and creating Mock MVC tests to use Spring Boot's testing functionalities
        - Learned about creating Rest APIs and the Rest tests
            - Differentiate between the getEntity and getObject for different purposes
        - [[debugging]]
            - Problem: stuck on rendering variable in view due to poorly formatted string
              Keywords: #[[debugging log]] #Strings
              Time taken to get unstuck: 0.5 hrs
              Main Takeaway: careful with HTML strings, if it can't render, check separately the view and the model to see which is having issues
            - Problem: Tests for Restful API controller failing
              Keywords: #[[debugging log]] #Java #[[Spring Boot]] #API
              Time taken to get unstuck: 0.5 hrs
              Main Takeaway: need to make sure that empty constructor for classes in Restful API is created
    - [[May 21st, 2021]]
        - Learn about the [[application context]], how  [[Spring Boot]] uses it to manage different [[Spring Beans]]
            - Understand the difference between [[autowiring]] by type, vs [[autowiring]] by name
            - Created my own [[Spring Beans]] in my demo application
        - Created a new project to learn about using services to make API calls to get information from Restful APIs
            - Understand more deeply how [[Java]] [[object-orientated programming]] is mapped onto [[JSON.stringify]] responses
            - Application properties can be manipulated to improve overall code
                - eg auto switching to snake case from camel case properties
        - [[debugging]]
            - Problem: Tests cannot run on the [[Spring Beans]] involving ctx
Tags: #[[debugging log]]
Time taken to get unstuck: 0.5 hrs
Main Takeaway: Turns out there was wrong `import` for the [[application context]] -- MAKE SURE TO CHECK THE IMPORTS 
    - [[May 22nd, 2021]]
        - Learning about [[JDBC templates]] in [[Spring Boot]]
            - [Getting Started | Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)

    - [[May 25th, 2021]]
        - Implemented [[Java DAO]] (Data Access Object) example with Test for a [[CRUID model]] [[persistence]] [[database]] 
            - Looked into learning a bit more about [[Java Streams]] vs [[for loop]]
                - Kind of like the special array methods of [[JavaScript]] that allows your to call on [[anonymous function]]
                - https://stackoverflow.com/questions/44180101/in-java-what-are-the-advantages-of-streams-over-loops
        - Learn about different `isolation levels` when reading from a `db` in transactions
            - Tradeoff quick vs safe
            - Phantom read -- read while there is another entry being added
                - Can be avoided with some lock, but there is additional overhead?
        - Learned about [[Spring Boot/transactional declaration]] helps with rollback (ie restoring the db)
        - Understand the differences between [[Spring Boot/JPA]] vs [[JDBC templates]] for different levels of abstractions ([[JPA]] is an abstraction of [[JDBC templates]]) 
        - Problem: Unable to generate the tests and qualifiers properly
    Tags: #[[debugging log]] 
    Time taken to get unstuck: 1 hrs
    Main Takeaway: Had a small type, had to update the applications.yml file for hybernate, though still not sure how it worked in the end?
    - [[May 27th, 2021]]
        - Used [[JAVA/myBatis]] to create a [[RESTful API]] endpoint example
        - [[JAVA/myBatis]] is similar to [[JDBC templates]] where you have to write your own [[SQL]]
        - Learned how to set it up with a [[MySQL]] db

