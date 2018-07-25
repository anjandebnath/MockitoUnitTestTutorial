#Unit test with Mockito

*Ackwoledgement* : This Project is created for getting familiar with Mockito JUnit test. 
 This repository is created by taking reference from following links:

- https://automationrhapsody.com/mock-junit-tests-mockito-example/
- https://semaphoreci.com/community/tutorials/stubbing-and-mocking-with-mockito-2-and-junit
- https://hackernoon.com/objects-vs-data-structures-e380b962c1d2
- https://stackoverflow.com/questions/36253040/example-on-mockitos-argumentcaptor
- https://javacodehouse.com/blog/junit-tutorial/
- http://www.baeldung.com/mockito-annotations
- https://javacodehouse.com/blog/mockito-tutorial/



##Custom template create for Junit4

From Android studio go to In the top menu, go to `file > Settings` 
and in the settings. In the left menu, find `Editor > File and Code templates` and click on the `Code Tab` 
and find `Junit4 Test Class`.

![see here](https://github.com/anjandebnath/MockitoUnitTestTutorial/blob/master/AS.PNG)


- Now its time to create a custom template for unit test
- Just copy and paste this and get some pre defined imports and methods.

````
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mock.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentCaptor.*;
import static org.mockito.ArgumentMatchers.*;



#parse("File Header.java")
@RunWith(MockitoJUnitRunner.class)
public class ${NAME} {

  //region constants
  
  //endregion constants
  
  //region helper fields
  
  //endregion helper fields

  ${CLASS_NAME} SUT;

  @Before
  public void setup() throws Exception{
      
     SUT = new ${CLASS_NAME} ();
     ${BODY}
  }
  
  //region helper methods
  
  //endregion helper methods
  
  //region helper classes
  
  //endregion helper classes
  
}
````

Thanks

Anjan Debnath