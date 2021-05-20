# learning-springboot

## Progress Log
- [[May 20th, 2021]]
    - Got to work on the basics of spring boot
    - Learned about how to implement the MVC framework in IntelliJ to run a web page on the local browser
    - Learned about AutoWiring and creating Mock MVC tests to use Spring Boot's testing functionalities
    - Learned about creating Rest APIs and the Rest tests
        - Differentiate between the getEntity and getObject classes
    - [[debugging]]
        - Problem: stuck on rendering variable in view due to poorly formatted string
          Keywords: #[[debugging log]] #Strings
          Time taken to get unstuck: 0.5 hrs
          Main Takeaway: careful with HTML strings, if it can't render, check separately the view and the model to see which is having issues
        - Problem: Tests for Restful API controller failing
          Keywords: #[[debugging log]] #Java #[[Spring Boot]] #API
          Time taken to get unstuck: 0.5 hrs
          Main Takeaway: need to make sure that empty constructor for classes in Restful API is created 
