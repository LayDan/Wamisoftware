# Test task from Wamisoftware for Java developer position
Spring Boot REST API for calculating the area and perimeter of geometric shapesS

# Shapes that we support
✔ Square \
✔ Rectangle \
✔ Triangle \
✔ Circle 

# Technologies
* Java 8+ 
* Spring Boot 2 
* Spring Web 
* JUnit 5 & AssertJ
* Gradle

# How to clone 
```bash
git clone https://github.com/LayDan/Wamisoftware.git
```

# How to run

```
gradle run
```
Or start it from [Main class](https://github.com/LayDan/Wamisoftware/blob/main/src/main/java/org/wamisoftware/Main.java)


# Architecture
In fact, it is very simple. [Calculator interface](https://github.com/LayDan/Wamisoftware/blob/main/src/main/java/org/wamisoftware/services/shapes/Calculator.java) acts as a contract and provides access to the methods of shapes.
Its implementations, for example [SquareCalculate](https://github.com/LayDan/Wamisoftware/blob/main/src/main/java/org/wamisoftware/services/shapes/calculators/SquareCalculate.java), call the model figures' methods, thereby providing validation and calculation. 
The figure model, for example [Square](https://github.com/LayDan/Wamisoftware/blob/main/src/main/java/org/wamisoftware/models/Square.java), provides us with its own calculation methods, I decided that this is better, since it is a static logic that should only be used by a certain figure.
It also allows us to test a single model and all its methods without using facade services so we can focus only on business logic.


# Tests
All tests are included in this [package](https://github.com/LayDan/Wamisoftware/tree/main/src/test/java/org/wamisoftware/models).
There are only model tests, because we do not need to test anything else, application is too small for this overhead.


# Validation
There was an option to use the validation module from Spring, but I decided to leave one query model and use internal object validation because it is more convenient and allows using this model for other figures, otherwise our model would look like this:

```java
@Getter
@Setter
public class ShapeRequest {
    
    @NotNull(message = "Shape type is required")
    private ShapeType shapeType;
    
    @Min(value = 1, message = "Dimension must be positive")
    private Double length; // For square, rectangle, triangle
    
    private Double width;  // For rectangle, triangle
    
    private Double height; // For triangle
    
    @Min(value = 1, message = "Radius must be positive")
    private Double radius; // For circle
}
```

And it doesn't look very good.
